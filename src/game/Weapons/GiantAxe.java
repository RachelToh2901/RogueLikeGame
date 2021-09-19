package game.Weapons;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import game.MeleeWeapon;
import game.activeSkills.SpinAttackAction;

public class GiantAxe extends MeleeWeapon {

    public GiantAxe (String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    @Override
    public WeaponAction getActiveSkill(Actor target, String direction) {
        return new SpinAttackAction(this);
    }
}
