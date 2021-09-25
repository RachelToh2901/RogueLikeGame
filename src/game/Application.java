package game;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.*;
import game.enemies.LordOfCinder;
import game.enemies.Skeleton;
import game.grounds.*;
import game.weapons.StormRuler;

/**
 * The main class for the Jurassic World game.
 *
 */
public class Application {

	public static void main(String[] args) {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Valley(), new Bonfire(), new Vendor(), new Cemetery());

			List<String> map = Arrays.asList(
					"..++++++..+++...........................++++......+++.................+++.......",
					"........+++++..............................+++++++.................+++++........",
					"...C.......+++.......................................................+++++......",
					"..............................................................C.........++......",
					".........................................................................+++....",
					"............................+.............................................+++...",
					".................C...........+++.......++++.....................................",
					".............................++.......+......................++++...............",
					".............................................................+++++++............",
					"..................................###___###...................+++...............",
					"..................................#_______#......................+++............",
					"...........++.....................#__FB___#.......................+.............",
					".........+++......................#_______#........................++...........",
					"............+++...................####_####..........................+..........",
					"..............+......................................................++.........",
					"..............++.................................................++++++.........",
					"............+++...................................................++++..........",
					"+..................................................................++...........",
					"++...+++.........................................................++++...........",
					"+++......................................+++........................+.++........",
					"++++.......++++.........................++.........................+....++......",
					"#####___#####++++.........C............+..................C............+..+.....",
					"_..._....._._#.++......................+...................................+....",
					"...+.__..+...#+++...........................................................+...",
					"...+.....+._.#.+.....+++++...++...................................C..........++.",
					"___.......___#.++++++++++++++.+++.............................................++");
			GameMap gameMap = new GameMap(groundFactory, map);
			world.addGameMap(gameMap);

			Actor player = new Player("Unkindled (Player)", '@', 10000);
//			world.addPlayer(player, gameMap.at(38, 12));
			world.addPlayer(player, gameMap.at(8, 25));

			// Place Yhorm the Giant/boss in the map
			gameMap.at(6, 25).addActor(new LordOfCinder());

			// Place a Hollow in the the map
			// FIXME: the Undead should be generated from the Cemetery
			// gameMap.at(32, 7).addActor(new Undead("Undead"));

		// Storm Ruler Spawn
		gameMap.at(7, 25).addItem(new StormRuler());

		// Spawn Skeleton
		int numOfSkeleton = 6;
		Random rand = new Random();

		for ( int i = 0; i < numOfSkeleton; i ++ ) {
			boolean added = false;
			while ( !added ){
				int x = rand.nextInt(gameMap.getXRange().max());
				int y = rand.nextInt(gameMap.getYRange().max());

				if ( gameMap.at( x, y).getActor() == null && gameMap.at( x, y).getGround() instanceof Dirt ) {
					gameMap.at(x,y).addActor(new Skeleton());
					added = true;
				}
			}
		}
//		gameMap.at(6,17).addActor(new Skeleton());
//		gameMap.at(6,9).addActor(new Skeleton());
//		gameMap.at(4,20).addActor(new Skeleton());
//		gameMap.at(42,6).addActor(new Skeleton());
//		gameMap.at(35,15).addActor(new Skeleton());
//		gameMap.at(6,3).addActor(new Skeleton());


		world.run();

	}
}
