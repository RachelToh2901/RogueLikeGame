package game.actions;

import edu.monash.fit2099.engine.*;
import game.ResetManager;
import game.interfaces.Resettable;

import java.util.List;

public class ResetAction extends Action {

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

    @Override
    public String menuDescription(Actor actor) {
        return "Rest at Firelink Shrine bonfire";
    }
}
