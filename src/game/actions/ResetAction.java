package game.actions;

import edu.monash.fit2099.engine.*;
import game.ResetManager;
import game.interfaces.Resettable;

import java.util.List;

/**
 * Special Action for Player to rest at FireLink Shrine
 */
public class ResetAction extends Action {

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // Reset all Actor
        ResetManager.getInstance().run(map);

        // Refill Maximum Hit Points
        if ( actor.isConscious() ) {
            return "Rested";
        } else {
            return "You Died!";
        }
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Rest at Firelink Shrine bonfire";
    }
}
