package game.weapons;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import game.activeSkills.SpinAttackAction;

public class GiantAxe extends MeleeWeapon {

    public GiantAxe () {
        //TODO: update displayChar
        super("Giant Axe", '?', 50, "smash", 80);
    }

    @Override
    public WeaponAction getActiveSkill(Actor target, String direction) {
        return new SpinAttackAction(this);
    }
}
