package game.enemies;

import edu.monash.fit2099.engine.*;
import game.actions.AttackAction;
import game.behaviors.FollowBehaviour;
import game.behaviors.WanderBehaviour;
import game.interfaces.Behaviour;
import game.interfaces.Resettable;
import game.interfaces.Soul;
import java.util.ArrayList;

/**
 * Class for enemies
 */
public class Enemies extends Actor implements Resettable, Soul {

  /**
   * List of behaviours that an enemy can perform
   */
  protected ArrayList<Behaviour> behaviours = new ArrayList<>();

  /**
   * Initial location of enemy on the map
   */
  protected Location initialLocation;

  /**
   * Number of souls the player gains if a particular enemy is killed
   */
  protected int soulReward;

  /**
   * Constructor.
   *
   * @param name        the name of the Actor
   * @param displayChar the character that will represent the Actor in the display
   * @param hitPoints   the Actor's starting hit points
   */
  public Enemies(String name, char displayChar, int hitPoints, int soulReward) {
    super(name, displayChar, hitPoints);
    this.behaviours.add(new WanderBehaviour());
    this.soulReward = soulReward;
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
    return null;
  }

  /**
   * Allows any classes that use this interface to reset abilities, attributes, and items.
   * @param map the map containing the Actor
   */
  @Override
  public void resetInstance(GameMap map) {
    this.hitPoints = maxHitPoints;
    behaviours.removeIf(behaviour -> behaviour instanceof FollowBehaviour);
    if ( initialLocation != null ) {
      map.moveActor(this, initialLocation);
    }
  }

  /**
   * Method to check if a particular instance is present in the game
   * @return the existence of the instance in the game.
   *
   */
  @Override
  public boolean isExist() {
    return true;
  }

  /**
   * Method for enemies to attack player
   * @param actions list of actions
   */
  public Action attackPlayer(Actions actions ) {

    // TODO : IMPLEMENT WEAPON ACTIVE SKILLS IN
    for ( Action action : actions ) {
      if ( action instanceof AttackAction) {
        Actor target = ((AttackAction) action).getTarget();
        behaviours.add(new FollowBehaviour(target));
        behaviours.removeIf(behaviour -> behaviour instanceof WanderBehaviour);
        return action;
      }
    }
    return null;
  }

  /**
   * Set value of initial Location
   *
   * @param location - initial location of enemy
   */
  public void setInitialLocation(Location location) {
    this.initialLocation = location;
  }

  /**
   * Method to remove enemy from map and add souls to player
   * @return a description of what happened that can be displayed to the user.
   *
   */
  public String die(GameMap map, Soul rewardedActor) {
    map.removeActor(this);
    this.transferSouls(rewardedActor);
    return this.name + " has been slain. Gained " + soulReward + " souls.";
  }

  /**
   * Transfer current instance's souls to another Soul instance.
   * @param soulObject a target souls.
   */
  @Override
  public void transferSouls(Soul soulObject) {
    soulObject.addSouls(this.soulReward);
  }
}
