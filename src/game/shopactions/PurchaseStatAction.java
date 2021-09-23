package game.shopactions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class PurchaseStatAction extends Action {
    protected int soulsCost = 200;
    @Override
    public String execute(Actor actor, GameMap map) {
//        if (actor.getSouls() >= soulsCost){
            actor.increaseMaxHp(25);
            //TODO: implement souls methods
//        actor.subtractSouls(soulsCost);
//        }else{
//            return actor + " does not have enough of souls. Purchase Failed";
//        }

        //return actor + " spent 200 souls and increased maximum hp by 25";
        // EDIT
        return menuDescription(actor);
    }


    // EDIT
    @Override
    public String menuDescription(Actor actor) {
        return actor + "buys max HP modifier (+25HP): " + soulsCost;
    }

    @Override
    public java.lang.String hotkey() {
        return "f";
    }
}
