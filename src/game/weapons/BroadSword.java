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
        super("Broad Sword", '%', 30, "hits", 80);

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
            damageDealt *= 2;
        }
        return damageDealt;

    }

}
