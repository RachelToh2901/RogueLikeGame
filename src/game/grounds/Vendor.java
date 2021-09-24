package game.grounds;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.shopactions.PurchaseBroadswordAction;
import game.shopactions.PurchaseGiantAxeAction;
import game.shopactions.PurchaseStatAction;
import game.weapons.BroadSword;
import game.weapons.GiantAxe;

public class Vendor extends Ground {

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
        return actions;
    }
}
