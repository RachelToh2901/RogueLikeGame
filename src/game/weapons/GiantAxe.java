package game.weapons;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import game.activeSkills.SpinAttackAction;
import game.shopActions.PurchaseGiantAxeAction;

import java.util.List;

public class GiantAxe extends MeleeWeapon {

    public GiantAxe () {
        //TODO: update displayChar
        super("Giant Axe", '?', 50, "smash", 80);
    }

    @Override
    public WeaponAction getActiveSkill(Actor target, String direction) {
        return new SpinAttackAction(this);
    }

    // EDIT
    @Override
    public List<Action> getAllowableActions() {
        boolean present = false;
        for(Action action: allowableActions) {
            if (action instanceof PurchaseGiantAxeAction) {
                present = true;
                break;
            }
        }
        if(!present){
            allowableActions.add(new PurchaseGiantAxeAction(new GiantAxe()));
        }
        return allowableActions.getUnmodifiableActionList();
    }
}
