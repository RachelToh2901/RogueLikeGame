package game.grounds;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.worldmap.Worldmap;

public class FogDoor extends Ground {

  private Worldmap destination;

  /**
   * Constructor.
   *
   * */
  public FogDoor(Worldmap destination) {
    super('=');
    this.destination = destination;
  }

  @Override
  public Actions allowableActions(Actor actor, Location location, String direction) {
    Actions actions = super.allowableActions(actor, location, direction);
    if ( location.getActor() != null ) {
      Location newLocation = destination.getFogDoorLocation();
      actions.add(new MoveActorAction(newLocation, "to " + destination.getName()));
    }
    return actions;
  }

  @Override
  public boolean canActorEnter(Actor actor) {
    return actor instanceof Player;
  }
}
