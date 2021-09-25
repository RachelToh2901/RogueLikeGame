package game.weapons;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.WeaponAction;
import edu.monash.fit2099.engine.WeaponItem;
import game.activeskills.ChargeAction;
import game.activeskills.WindSlashAction;

import java.util.List;
import java.util.Random;

/**
 * Storm Ruler weapon
 */
public class StormRuler extends MeleeWeapon {

    /**
     * Constructor
     */
    public StormRuler () {
        super("Storm Ruler", '7', 70, " slam ", 60);
    }

    /**
     * The amount of damage the StormRuler will inflict
     *
     * @return the damage, in hitpoints
     */
    @Override
    public int damage() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        int damageDealt = this.damage;
        if (randomNumber <= 20) {
            damageDealt *= 2;
        }
        return damageDealt;
    }

    /**
     * Get an action or skill from the weapon that will be used against one target.
     * This method allows StormRuler instance to interact with Actor class.
     * @see WeaponItem#allowableActions for a self-direction skill instead of using this method (recommendation)
     * @return null by default because a weapon doesn't have any active skill. Otherwise, return a WeaponAction instance.
     */
    public WeaponAction getActiveSkill() {
        int chargeCount = ChargeAction.getNumOfCharge();
        if (chargeCount <3){
            return new ChargeAction(this);
        }else{
            return new WindSlashAction(this);
        }
    }

    @Override
    public List<Action> getAllowableActions() {
        Action activeSkill = getActiveSkill();
        boolean presentCharge = activeSkill instanceof ChargeAction;
        boolean presentWindSlash = activeSkill instanceof WindSlashAction;
        boolean present = false;
        for (Action action : allowableActions) {
            if (presentCharge) {
                if (action instanceof ChargeAction) {
                    present = true;
                }
                if (action instanceof WindSlashAction) {
                    allowableActions.remove(action);
                }
            } else if (presentWindSlash) {
                if (action instanceof WindSlashAction) {
                    present = true;
                }
                if (action instanceof ChargeAction) {
                    allowableActions.remove(action);
                }
            }
        }
        if (!present) {
            allowableActions.add(activeSkill);
        }
        return allowableActions.getUnmodifiableActionList();
    }
//        boolean present1 = false;
//        boolean present2 = false;
//        int chargeCount = ChargeAction.getNumOfCharge();
//        for(Action action: allowableActions) {
//            if (action instanceof ChargeAction) {
//                present1 = true;
//                break;
//            }
//        }
//        for(Action action: allowableActions) {
//            if (action instanceof WindSlashAction) {
//                present2 = true;
//                break;
//            }
//        }
//        System.out.println("Present Charge: " + present1);
//        System.out.println("Present WindSlash: " + present2);
//        if(!present1 && chargeCount < 3){
//            allowableActions.add(new ChargeAction(this));
//            if (present2){
//                allowableActions.remove(new WindSlashAction(this));
//            }
//        }
//        if(!present2 && chargeCount == 3){
//            allowableActions.remove(new ChargeAction(this));
//            allowableActions.add((new WindSlashAction(this)));
//        }
//        return allowableActions.getUnmodifiableActionList();
//    }

    public int dullness(){
        int damageDealt = this.damage;
        return damageDealt/2;
    }
}
