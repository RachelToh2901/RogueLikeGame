package game.weapons;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import game.activeSkills.BurnGroundAction;

public class YhormsGiantMachete extends MeleeWeapon {

    public YhormsGiantMachete () {
        //TODO: update displayChar
        super("Yhorm Giant Machete", '?', 95, "hits", 60);
    }

    public void activateEmberForm (){
        hitRate *= 30/100;
    }

    @Override
    public WeaponAction getActiveSkill(Actor target, String direction) {
        return new BurnGroundAction(this);
    }
}
