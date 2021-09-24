package game.weapons;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import edu.monash.fit2099.engine.WeaponItem;
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
        super("Giant Axe", '?', 50, "smash", 80);
    }

    /**
     * Get an action or skill from the weapon that will be used against one target.
     * This method allows Giant Axe instance to interact with Actor class.
     * @see WeaponItem#allowableActions for a self-direction skill instead of using this method (recommendation)
     * @param target the target actor
     * @param direction the direction of target, e.g. "north"
     * @return null by default because a weapon doesn't have any active skill. Otherwise, return a WeaponAction instance.
     */
    @Override
    public WeaponAction getActiveSkill(Actor target, String direction) {
        return new SpinAttackAction(this);
    }

}
