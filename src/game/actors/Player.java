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
import game.items.EstusFlask;
import game.weapons.BroadSword;
import game.weapons.GiantAxe;
import game.weapons.StormRuler;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Soul {

	// Question: we already have hitPoints in actor class ?
	private final Menu menu = new Menu();
	//private EstusFlask estusFlask = new EstusFlask("Estus Flask",'E',true);
	//private BroadSword broadSword = new BroadSword();
	//private GiantAxe giantAxe = new GiantAxe();
	//private StormRuler stormRuler = new StormRuler();
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
		this.addItemToInventory(new EstusFlask());
		this.addItemToInventory(new BroadSword());
		this.maxHitPoints = 100;

		// Question: Do we need to add giantAxe and stormRuler to inventory
		//this.addItemToInventory(giantAxe);
		//this.addItemToInventory(stormRuler);
	}


	public int getMaxHitPoints() {
		return maxHitPoints;
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
		display.println("Unkindled" + "(" + hitPoints + "/" + maxHitPoints + ")" + ", holding BroadSword, " + "souls" + " Souls");
		return menu.showMenu(this, actions, display);
	}

	@Override
	public void transferSouls(Soul soulObject) {
		//TODO: transfer Player's souls to another Soul's instance.
	}

}
