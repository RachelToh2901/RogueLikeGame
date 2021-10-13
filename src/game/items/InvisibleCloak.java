package game.items;

import edu.monash.fit2099.engine.*;
import game.actions.InvisibleAction;
import game.actions.RetrieveSoulAction;

import java.util.List;

public class InvisibleCloak extends Item {

    /***
     * Constructor.
     */
    public InvisibleCloak() {
        super("Invisible Cloak", '?', false);
    }

    @Override
    public List<Action> getAllowableActions() {
        boolean present = false;
        for(Action action: allowableActions) {
            if (action instanceof InvisibleAction) {
                present = true;
                break;
            }
        }
        if(!present){
            allowableActions.add(new InvisibleAction());
        }
        return allowableActions.getUnmodifiableActionList();
    }

}
