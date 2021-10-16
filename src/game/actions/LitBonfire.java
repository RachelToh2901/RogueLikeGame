package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.Player;
import game.grounds.Bonfire;

/**
 * Class that performs the light bonfire action
 */
public class LitBonfire extends Action {

  /**
   * Creating instance of Bonfire
   */
  private Bonfire bonfire;
  /**
   * Constructor
   * @param bonfire
   */
  public LitBonfire(Bonfire bonfire) {
    this.bonfire = bonfire;
  }

  /**
   * Method to light the bonfire
   * @param actor The actor performing the action.
   * @param map The map the actor is on.
   * @return a description of what happened that can be displayed to the Player
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    bonfire.litBonfire();
    return bonfire.getName() + " has been lit.";
  }

  /**
   * Method that returns a descriptive string
   * @param actor The actor performing the action.
   * @return a description of what happened that can be displayed to the Player
   */
  @Override
  public String menuDescription(Actor actor) {
    return "lit " + bonfire.getName();
  }
}
