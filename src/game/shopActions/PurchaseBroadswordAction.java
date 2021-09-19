package game.shopActions;

import edu.monash.fit2099.engine.Item;
import game.shopActions.PurchaseWeaponAction;

public class PurchaseBroadswordAction extends PurchaseWeaponAction {

    /**
     * Constructor
     *
     * @param weapon the new item that will replace the weapon in the Actor's inventory.
     */
    public PurchaseBroadswordAction(Item weapon) {
        super(weapon);
    }
}
