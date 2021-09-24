package game.actions;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.ResetManager;
import game.grounds.Valley;
import game.interfaces.Resettable;
import game.items.TokenOfSouls;

import javax.management.ValueExp;
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
        // Check if Player died or rested
        if ( actor.isConscious() ) {
            ResetManager.getInstance().run(map);
            return "Rested. Maximum Hit Points and Estus Flask have been refilled.";
        } else {
            Location playerLastLocation;

            if ( map.locationOf(actor).getGround() instanceof Valley ) {
                playerLastLocation = ((Player) actor).getLastLocation();
            } else {
                playerLastLocation = map.locationOf(actor);
            }

            ResetManager.getInstance().run(map);
            playerLastLocation.addItem(new TokenOfSouls(actor));
            ((Player) actor).subtractSouls(((Player) actor).getSouls());

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
