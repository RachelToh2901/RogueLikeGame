package game.shopActions;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;
import game.actions.SwapWeaponAction;
import game.items.TokenOfSouls;

import java.util.List;

public class PurchaseWeaponAction extends SwapWeaponAction {

    /**
     * Constructor
     *
     * @param weapon the new item that will replace the weapon in the Actor's inventory.
     */

    // Question : Should I use Item or WeaponItem?
    public PurchaseWeaponAction(Item weapon) {
        super(weapon);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Question : Should I use actor.getWeapon or this.weapon (initialised in constructor)
        Weapon currentWeapon = actor.getWeapon();
        List<Item> items = actor.getInventory();

        // loop through all inventory
        for(Item item : items){
            if(item.asWeapon() != null){
                actor.removeItemFromInventory(item);
                break; // after it removes that weapon, break the loop.
            }
        }

        // if the ground has item, remove that item.
        // additionally, add new weapon to the inventory (equip).
        actor.addItemToInventory(item);
        return actor + " purchase " + currentWeapon;
    }

}
