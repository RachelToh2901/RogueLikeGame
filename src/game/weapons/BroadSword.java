package game.weapons;

import edu.monash.fit2099.engine.Action;
import game.shopactions.PurchaseBroadswordAction;

import java.util.List;
import java.util.Random;

/**
 * BroadSword weapon
 */
public class BroadSword extends MeleeWeapon {

    /**
     * Constructor
     */
    public BroadSword() {
        //TODO: update displayChar of Broad Sword
        super("Broad Sword", '?', 30, "hits", 80);
    }

    /**
     * The amount of damage the BroadSword will inflict
     *
     * @return the damage, in hitpoints
     */
    @Override
    public int damage() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        int damageDealt = this.damage;
        if (randomNumber <= 20) {
            System.out.println("double damage is dealt!");
            return damageDealt * 2;
        }else{
            return damageDealt;
        }
    }

//    /**
//     * Getter.
//     *
//     * Returns an unmodifiable copy of the actions list so that calling methods won't
//     * be able to change what this Item can do without the Item checking.
//     * @return an unmodifiable list of Actions
//     */
//    @Override
//    public List<Action> getAllowableActions() {
//        boolean present = false;
//        for(Action action: allowableActions) {
//            if (action instanceof PurchaseBroadswordAction) {
//                present = true;
//                break;
//            }
//        }
//        if(!present){
//            allowableActions.add(new PurchaseBroadswordAction(new BroadSword()));
//        }
//        return allowableActions.getUnmodifiableActionList();
//    }

}
