package game.shopActions;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.shopActions.PurchaseWeaponAction;

// EDIT

public class PurchaseStormRulerAction extends PurchaseWeaponAction {
    protected int soulsCost = 2000;

    /**
     * Constructor
     *
     * @param weapon the new item that will replace the weapon in the Actor's inventory.
     */
    public PurchaseStormRulerAction(Item weapon) {
        super(weapon);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
//        if (actor.getSouls() >= soulsCost) {
        super.execute(actor, map);
        //TODO: implement souls methods in player class
//        actor.subtractSouls(soulsCost);
//        }else{
//          return actor " does not have enough souls. Purchase FAILED.";
//      }
        return menuDescription(actor);
    }

    // EDIT
    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + "Storm Ruler" +  "(" + soulsCost + " souls" + ")";
    }

    @Override
    public java.lang.String hotkey() {
        return "e";
    }
}
