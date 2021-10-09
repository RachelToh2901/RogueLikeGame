package game.shopactions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.Player;

/**
 * Class for Player to purchase stats(increase maximum hit points by 25) from the Vendor
 */
public class PurchaseStatAction extends Action {

    /**
     * Number of souls that it costs to increase maximum HP
     */
    protected int soulsCost = 200;

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (((Player) actor).getSouls() >= soulsCost) {
            actor.increaseMaxHp(25);
            ((Player) actor).subtractSouls(soulsCost);
        }else{
            return actor + " does not have enough souls. Purchase FAILED.";
        }

        return menuDescription(actor);
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + "buys max HP modifier (+25HP): " + soulsCost;
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     *
     * @return The key we use for this Action in the menu, or null to have it assigned for you.
     */
    @Override
    public java.lang.String hotkey() {
        return "f";
    }
}
