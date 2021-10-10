package game.grounds;

import edu.monash.fit2099.engine.*;
import game.items.C4Bomb;
import game.shopactions.*;
import game.weapons.BroadSword;
import game.weapons.GiantAxe;

/**
 * Class for creating a Vendor where Player can buy BroadSword, Giant Axe or increase maximum hit points by 25
 */
public class Vendor extends Ground {

//    PurchaseAction purchaseAction;

    /**
     * Constructor.
     *
     */
    public Vendor() {
        super('F');
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();
        actions.add(new PurchaseBroadswordAction(new BroadSword()));
        actions.add(new PurchaseGiantAxeAction(new GiantAxe()));
        actions.add(new PurchaseStatAction());
        boolean existBomb = false;
        for (Item item : actor.getInventory()){
            if (item instanceof C4Bomb){
                existBomb = true;
                break;
            }
        }
        if (!existBomb){
            actions.add(new PurchaseC4BombAction(new C4Bomb(actor)));
        }
//        actions.add(new PurchaseAction());
        return actions;
    }

//    public Action setPurchaseAction(){
//        this.purchaseAction =
//    }
}
