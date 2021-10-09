package game.shopactions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.Player;

public abstract class PurchaseAction extends Action {

    private int soulsCost;

    public PurchaseAction(int soulsCost){
        setSoulsCost(soulsCost);
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        if (((Player) actor).getSouls() >= soulsCost) {
            ((Player) actor).subtractSouls(soulsCost);
            doAction(actor, map);
        }else{
            return actor + " does not have enough souls. Purchase FAILED.";
        }

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchase ";
    }

    public abstract void doAction(Actor actor, GameMap map);

    public void setSoulsCost(int soulsCost) {
        if (soulsCost >= 0){
            this.soulsCost = soulsCost;
        }
    }

    public int getSoulsCost(){
        return soulsCost;
    }
}
