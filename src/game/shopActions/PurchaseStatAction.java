package game.shopActions;

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
        return actor + " spent 200 souls and increased maximum hp by 25";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "spend 200 souls to increase maximum hp by 25";
    }
}
