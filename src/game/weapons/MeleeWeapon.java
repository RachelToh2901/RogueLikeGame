package game.weapons;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.WeaponItem;

import java.util.Random;

public class MeleeWeapon extends WeaponItem {
    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public MeleeWeapon(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    //TODO: please figure out how to disable dropping item action.

    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }

//    public void setChanceToHit(int newChanceToHit){hitRate = newChanceToHit;}

    //should we implement here?
//    public int criticalStrike(int successRate){
//        Random rand = new Random();
//        int randomNumber = rand.nextInt(100);
//        if (randomNumber>=0 && randomNumber<= successRate){
//            return damage *= 2;
//        }else{
//            return damage;
//        }
//    }
}
