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
     * @param displayChar character to display for this type of terrain
     */
    public Vendor(char displayChar) {
        super('F');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();
        actions.add(new PurchaseBroadswordAction(new BroadSword()));
        actions.add(new PurchaseGiantAxeAction(new GiantAxe()));
        actions.add(new PurchaseStatAction());
        return actions;
    }
}
