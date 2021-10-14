package game.actions;

import edu.monash.fit2099.engine.*;
import game.items.InvisibleCloak;

import static game.enums.Status.INVISIBLE;

public class InvisibleAction extends Action {

    private InvisibleCloak invisibleCloak;

    public InvisibleAction(InvisibleCloak invisibleCloak){
        this.invisibleCloak = invisibleCloak;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addCapability(INVISIBLE);
        invisibleCloak.actorUsing();

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " turns invisible";
    }
}
