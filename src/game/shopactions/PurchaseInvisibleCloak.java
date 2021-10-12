package game.shopactions;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.items.InvisibleCloak;

public class PurchaseInvisibleCloak extends PurchaseAction{

    Item item;

    public PurchaseInvisibleCloak(Item item) {
        super(200);
        this.item = item;
    }

    @Override
    public void doAction(Actor actor, GameMap map) {
        actor.addItemToInventory(item);
    }

    public String menuDescription(Actor actor){
        return super.menuDescription(actor) + item.toString() + " with 200 souls";
    }
}
