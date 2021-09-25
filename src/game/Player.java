package game;

import edu.monash.fit2099.engine.*;
import game.actions.AttackAction;
import game.actions.ResetAction;
import game.actions.SwapWeaponAction;
import game.activeskills.ChargeAction;
import game.activeskills.SpinAttackAction;
import game.activeskills.WindSlashAction;
import game.enums.Abilities;
import game.enums.Status;
import game.interfaces.Resettable;
import game.interfaces.Soul;
import game.items.EstusFlask;
import game.items.TokenOfSouls;
import game.weapons.BroadSword;
import game.items.EstusFlask;
import game.weapons.StormRuler;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Soul, Resettable {

	/**
	 * Creating new instance of Menu class
	 */
	private final Menu menu = new Menu();

	/**
	 * Last location of Player
	 */
	private Location lastSavedLocation = null;

	/**
	 * Number of Souls that the Player has
	 */
	private int souls;
	private Location lastLocation;
	private Location previousTokenLocation = null;
	private TokenOfSouls previousTokenOfSouls = null;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, 100000);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Abilities.REST);
		this.registerInstance();
		this.addItemToInventory(new EstusFlask());
		this.addItemToInventory(new BroadSword());
		this.souls = 100000;
	}

	/**
	 * Getter
	 * Get value of maxHitPoints
	 *
	 * @return maxHitPoints- maximum hit points of player
	 */
	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	/**
	 * Select and return an action to perform on the current turn.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {


		if ( lastSavedLocation == null ) {
			setLastSavedLocation(map.locationOf(this));
		}
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();


		// Save Previous Location
		lastLocation = map.locationOf(this);

		// return/print the console menu
		// print health points using display
		display.println("Unkindled" + "(" + hitPoints + "/" + maxHitPoints + ")" + ", holding " + this.getWeapon() + ", " + souls + " Souls");
		if (this.getWeapon() instanceof StormRuler){
			int numOfCharge = ChargeAction.getNumOfCharge();
			if (numOfCharge == 0){
				display.println("Storm Ruler not Charged");
			} else if (numOfCharge == 3){
				display.println("Storm Ruler is FULLY CHARGED");
			} else{
				display.println("Charging Storm Ruler");
			}
		}
		return menu.showMenu(this, actions, display);

	}

	/**
	 * Transfer current instance's souls to another Soul instance.
	 *
	 * @param soulObject a target souls.
	 */
	@Override
	public void transferSouls(Soul soulObject) {
		//TODO: transfer Player's souls to another Soul's instance.
	}

	/**
	 * Allows any classes that use this interface to reset abilities, attributes, and items.
	 *
	 * @param map the map containing the Player
	 */
	@Override
	public void resetInstance(GameMap map) {
		if ( isConscious() ) {
			setLastSavedLocation(map.locationOf(this));
		} else  {
			this.subtractSouls(this.getSouls());
			map.moveActor(this, lastSavedLocation);
		}

		this.hitPoints = maxHitPoints;
		getEstusFlask().setChargesLeft(3);

	}

	/**
	 * A useful method to clean up the list of instances
	 *
	 * @return the existence of the instance in the game.
	 */
	@Override
	public boolean isExist() {
		return true;
	}

	/**
	 * Method that registers current instance
	 */
	@Override
	public void registerInstance() {
		Resettable.super.registerInstance();
	}

	/**
	 * Getter
	 * Get EstusFlask object
	 *
	 * @return EstusFlask - Estus Flask object
	 */
	public EstusFlask getEstusFlask() {
		for (Item item : this.inventory) {
			if (item instanceof EstusFlask ) {
				return (EstusFlask) item;
			}
		}
		return null;
	}

	/**
	 * Setter.
	 * Set value of location
	 *
	 * @param location - last location of Player
	 */
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

	@Override
	public boolean subtractSouls(int souls) {
		this.souls -= souls;
		return true;
	}

	/**
	 * Getter
	 * Get value of totalCharges
	 *
	 * @return souls - number of souls that the player has
	 */
	public int getSouls(){
		return this.souls;
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		actions.add(new AttackAction(this, direction));
		for (Item item: this.getInventory()){
			if (item instanceof StormRuler && !(this.getWeapon() instanceof StormRuler)){
				((StormRuler) item).setHolder(this);
				SwapWeaponAction swapWeaponAction = new SwapWeaponAction(item);
				swapWeaponAction.execute(this, map);
			}
		}
		return actions;
	}

	public void setPreviousTokenLocation(Location location){
		this.previousTokenLocation = location;
	}

	public Location getPreviousTokenLocation(){
		return this.previousTokenLocation;
	}

	public void setPreviousTokenOfSouls(TokenOfSouls tokenOfSouls){
		this.previousTokenOfSouls = tokenOfSouls;
	}

	public TokenOfSouls getPreviousTokenOfSouls(){
		return this.previousTokenOfSouls;
	}
}
