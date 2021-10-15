package game.shopactions;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.Player;

/**
 * Class for player to purchase Giant Axe from Vendor
 */
public class PurchaseGiantAxeAction extends PurchaseWeaponAction {

    /**
     * Number of souls that it costs to buy Giant Axe
     */
    protected int soulsCost;

    /**
     * Constructor
     *
     * @param weapon the new item that will replace the weapon in the Actor's inventory.
     */
    public PurchaseGiantAxeAction(Item weapon) {
        super(weapon, 1000);
    }
}
