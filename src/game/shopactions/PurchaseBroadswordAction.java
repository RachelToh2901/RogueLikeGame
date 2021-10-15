package game.shopactions;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.Player;

/**
 * Class for Player to purchase BroadSword from Vendor
 */
public class PurchaseBroadswordAction extends PurchaseWeaponAction {

    /**
     * Number of souls that it costs to buy BroadSword
     */
    protected int soulsCost;

    /**
     * Constructor
     *
     * @param weapon the new item that will replace the weapon in the Actor's inventory.
     */
    public PurchaseBroadswordAction(Item weapon) {
        super(weapon, 500);
    }
}
