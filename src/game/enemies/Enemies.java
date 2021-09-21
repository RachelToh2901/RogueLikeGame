package game.enemies;

import edu.monash.fit2099.engine.*;
import game.actions.AttackAction;
import game.behaviors.FollowBehaviour;
import game.behaviors.WanderBehaviour;
import game.interfaces.Behaviour;
import game.interfaces.Resettable;
import game.interfaces.Soul;

import java.util.ArrayList;

public class Enemies extends Actor implements Resettable, Soul {

  protected ArrayList<Behaviour> behaviours = new ArrayList<>();
  protected Location initialLocation;
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

  @Override
  public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
    return null;
  }

  @Override
  public void resetInstance(GameMap map) {
    this.hitPoints = maxHitPoints;
    behaviours.removeIf(behaviour -> behaviour instanceof FollowBehaviour);
    if ( initialLocation != null ) {
      map.moveActor(this, initialLocation);
    }
  }

  @Override
  public boolean isExist() {
    return true;
  }

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

  public void setInitialLocation(Location location) {
    this.initialLocation = location;
  }

  public String die(GameMap map, Soul rewardedActor) {
    map.removeActor(this);
    this.transferSouls(rewardedActor);
    return this.name + " has been slain. Gained " + soulReward + " souls.";
  }

  @Override
  public void transferSouls(Soul soulObject) {
    soulObject.addSouls(this.soulReward);
  }
}
