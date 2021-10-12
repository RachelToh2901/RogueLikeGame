package game.shopactions;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class PurchaseC4BombAction extends PurchaseAction {

    private int soulsCost = 200;
    private Item item;

    public PurchaseC4BombAction(Item item){
        super(200);
        this.item = item;
    }

    @Override
    public String menuDescription(Actor actor) {
        return super.menuDescription(actor) + "C4 Bomb with " + getSoulsCost() + " souls";
    }

    @Override
    public void doAction(Actor actor, GameMap map) {
        actor.addItemToInventory(item);
    }


}
