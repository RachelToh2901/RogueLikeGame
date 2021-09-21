package game.actors;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;
import game.enums.Abilities;
import game.enums.Status;
import game.interfaces.Soul;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Soul {

	// Question : We already have hitPoints in Actor class?
	private static int hitPoints;
	private final Menu menu = new Menu();
	//	private Soul numOfSouls;
	// int souls

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Abilities.REST);
	}

	// Question : static?
	public static int getHitPoints() {
		return hitPoints;
	}


	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// Game over when Player is defeated
		if (!this.isConscious()) {
			System.out.print("GAME OVER !");
			System.exit(0);
		}

		// return/print the console menu
		// print health points using display
		return menu.showMenu(this, actions, display);

		// insert actions
		// action = menu.showmenu
		// action.execute
		// return result
	}

//	@Override
//	public boolean subtractSouls(int souls) {
//		numOfSouls -= souls;
//	}

	@Override
	public void transferSouls(Soul soulObject) {
		//TODO: transfer Player's souls to another Soul's instance.
	}
}
