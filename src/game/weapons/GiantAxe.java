package game.weapons;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import edu.monash.fit2099.engine.WeaponItem;
import game.actions.RetrieveSoulAction;
import game.activeskills.SpinAttackAction;
import game.shopactions.PurchaseGiantAxeAction;

import java.util.List;

/**
 * Giant Axe weapon
 */
public class GiantAxe extends MeleeWeapon {

    /**
     * Constructor
     */
    public GiantAxe () {
        //TODO: update displayChar
        super("Giant Axe", 'T', 50, "flink", 80);
    }


    @Override
    public List<Action> getAllowableActions() {
        boolean present = false;
        for(Action action: allowableActions) {
            if (action instanceof SpinAttackAction) {
                present = true;
                break;
            }
        }
        if(!present){
            allowableActions.add(new SpinAttackAction(this));
        }
        return allowableActions.getUnmodifiableActionList();
    }
}
