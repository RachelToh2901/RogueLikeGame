package game.weapons;

import edu.monash.fit2099.engine.*;
import game.enums.Abilities;
import game.grounds.Wall;

public class LongRangedWeapon extends WeaponItem {
    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public LongRangedWeapon(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
        super.addCapability(Abilities.LONG_RANGED_WEAPON);
    }

    public String rangedWeapon(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        String result = "";
        for (Exit exit : here.getExits()) {
            Ground currentGround = exit.getDestination().getGround();
            if (currentGround instanceof Wall) {
                result =  "Weapon missed" + actor;
            }
            if (exit.getDestination().containsAnActor()) {
                Actor target = exit.getDestination().getActor();
                target.hurt(damage);
                result = "Weapon hits" + target + "for" + damage + "damage";
            }
        }
        return result;
    }

}
