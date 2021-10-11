package game.worldmap;

import edu.monash.fit2099.demo.mars.Stick;
import edu.monash.fit2099.engine.*;
import game.BonFireManager;
import game.Player;
import game.enemies.LordOfCinder;
import game.enemies.Skeleton;
import game.grounds.*;
import game.weapons.StormRuler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProfaneCapital extends Worldmap {



  public ProfaneCapital( World world, BonFireManager bonFireManager, MapsManager mapsManager) {
    super("Profane Capital", world, bonFireManager, mapsManager);

    FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Valley(), new Vendor(), new Cemetery());

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
        "...........++.....................#__F____#.......................+.............",
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
    this.map = new GameMap(groundFactory, map);
    world.addGameMap(this.map);
    mapsManager.addMap(this);
    spawnEnemies();
    spawnBonfire();
  }

  public void addPlayer(String name, char displayChar, int hitPoints) {
    Actor player = new Player(name, displayChar,hitPoints);
    world.addPlayer(player, this.map.at(38, 12));
  }

  @Override
  public void spawnEnemies(){
    // Spawn Yhorm the Giant ( Boss )
    this.map.at(6, 25).addActor(new LordOfCinder());

    // Storm Ruler Spawn
    this.map.at(7, 25).addItem(new StormRuler(null));

    // Spawn Skeleton
    int numOfSkeleton = 6;
    Random rand = new Random();

    for ( int i = 0; i < numOfSkeleton; i ++ ) {
      boolean added = false;
      while ( !added ){
        int x = rand.nextInt(this.map.getXRange().max());
        int y = rand.nextInt(this.map.getYRange().max());

        if ( this.map.at( x, y).getActor() == null && this.map.at( x, y).getGround() instanceof Dirt ) {
          this.map.at(x,y).addActor(new Skeleton());
          added = true;
        }
      }
    }
  }

  @Override
  public void spawnFogDoor() {
    // Spawning Fog Door to Anor Londo
    this.map.at(38,25).setGround(new FogDoor(this.mapsManager.getMap("Anor Londo")));
    this.fogDoorLocation = this.map.at(38,25);
  }

  @Override
  public void spawnBonfire() {
    bonfire = new Bonfire(name + "'s Bonfire");
    bonfire.litBonfire();
    bonfire.setBonFireManager(bonFireManager, this.map.at(38, 11));
    this.map.at(38, 11).setGround(bonfire);
  }
}
