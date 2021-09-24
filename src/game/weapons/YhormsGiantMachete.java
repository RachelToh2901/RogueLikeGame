package game.weapons;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
/**
 * Yhorm's Giant Machete weapon
 */
public class YhormsGiantMachete extends MeleeWeapon {
    /**
     * Constructor
     */
    public YhormsGiantMachete () {
        //TODO: update displayChar
        super("Yhorm Giant Machete", '?', 95, "hits", 60);
    }

    /**
     * Method to activate Ember form of Yhorm the Giant
     */
    public void activateEmberForm (){
        hitRate += 30;
    }

}
