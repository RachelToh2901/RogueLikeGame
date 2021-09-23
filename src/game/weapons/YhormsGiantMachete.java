package game.weapons;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;

public class YhormsGiantMachete extends MeleeWeapon {

    public YhormsGiantMachete () {
        //TODO: update displayChar
        super("Yhorm Giant Machete", '?', 95, "hits", 60);
    }

    public void activateEmberForm (){
        hitRate *= 30/100;
    }

}
