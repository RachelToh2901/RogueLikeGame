package game.weapons;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import game.activeskills.ChargeAction;
import game.activeskills.WindSlashAction;
import game.shopactions.PurchaseStormRulerAction;

import java.util.List;
import java.util.Random;

public class StormRuler extends MeleeWeapon {

    public StormRuler () {
        super("Storm Ruler", '7', 70, " attacks ", 60);
    }

    @Override
    public int damage() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        if (randomNumber <= 20) {
            return damage *= 2;
        }else{
            return damage;
        }
    }

    // EDIT
    @Override
    public WeaponAction getActiveSkill(Actor target, String direction) {
        int chargeCount = ChargeAction.getNumOfCharge();
        if (chargeCount <3){
            return new ChargeAction(this);
        }else{
            return new WindSlashAction(this, target, direction);
        }
    }

    @Override
    public List<Action> getAllowableActions() {
        boolean present = false;
        for(Action action: allowableActions) {
            if (action instanceof PurchaseStormRulerAction) {
                present = true;
                break;
            }
        }
        if(!present){
            allowableActions.add(new PurchaseStormRulerAction(new StormRuler()));
        }
        return allowableActions.getUnmodifiableActionList();
    }
}
