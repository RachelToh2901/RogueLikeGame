package game;

import edu.monash.fit2099.engine.*;
import game.actions.ResetAction;
import game.enums.Abilities;
import game.enums.Status;
import game.interfaces.Resettable;
import game.interfaces.Soul;
import game.items.EstusFlask;
import game.items.TokenOfSouls;
import game.weapons.BroadSword;
import game.items.EstusFlask;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Soul, Resettable {

	private final Menu menu = new Menu();
	private Location lastSavedLocation;
	private int souls;
	private Location lastLocation;

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
		this.registerInstance();
		this.addItemToInventory(new EstusFlask());
		this.addItemToInventory(new BroadSword());
		this.maxHitPoints = 100;

		this.souls = 0;
	}


	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		if ( lastAction == null || lastAction instanceof ResetAction) {
			setLastSavedLocation(map.locationOf(this));
		}
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		lastLocation = map.locationOf(this);
		// return/print the console menu
		// print health points using display
		display.println("Unkindled" + "(" + hitPoints + "/" + maxHitPoints + ")" + ", holding BroadSword, " + souls + " Souls");
		return menu.showMenu(this, actions, display);

	}

	@Override
	public void transferSouls(Soul soulObject) {
		//TODO: transfer Player's souls to another Soul's instance.
	}

	@Override
	public void resetInstance(GameMap map) {
		this.hitPoints = maxHitPoints;
		this.getEstusFlask().setChargesLeft(3);
		map.moveActor(this, lastSavedLocation);
	}

	@Override
	public boolean isExist() {
		return true;
	}

	@Override
	public void registerInstance() {
		Resettable.super.registerInstance();
	}

	private EstusFlask getEstusFlask() {
		for (  Item item : this.inventory ) {
			if ( item.toString().equals("Estus Flask")){
				return (EstusFlask) item;
			}
		}
		return null;
	}

	public void setLastSavedLocation(Location location) {
		this.lastSavedLocation = location;
	}

	public Location getLastLocation(){
		return this.lastLocation;
	}

	@Override
	public boolean addSouls(int souls){
		this.souls += souls;
		return true;
	}

	public int getSouls(){
		return this.souls;
	}
}
