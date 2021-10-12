package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.grounds.Bonfire;

public class LitBonfire extends Action {

  private Bonfire bonfire;

  public LitBonfire(Bonfire bonfire) {
    this.bonfire = bonfire;
  }
  @Override
  public String execute(Actor actor, GameMap map) {
    bonfire.litBonfire();
    return bonfire.getName() + " has been lit.";
  }

  @Override
  public String menuDescription(Actor actor) {
    return "lit " + bonfire.getName();
  }
}
