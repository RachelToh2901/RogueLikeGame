package game.actions;

import edu.monash.fit2099.engine.*;
import game.enemies.Enemies;

public class InvisibleAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit: here.getExits()){
            if (exit.getDestination().containsAnActor()){
                Actor target = exit.getDestination().getActor();
                if (target instanceof Enemies){
                    ((Enemies) target).checkIsPlayerNear(null);
                }
            }
        }

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " turns invisible";
    }
}
