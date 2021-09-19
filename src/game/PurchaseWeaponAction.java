package game;

import edu.monash.fit2099.engine.Item;

public class PurchaseWeaponAction extends SwapWeaponAction{

    /**
     * Constructor
     *
     * @param weapon the new item that will replace the weapon in the Actor's inventory.
     */
    public PurchaseWeaponAction(Item weapon) {
        super(weapon);
    }
}
