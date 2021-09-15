package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;

public class EstusFlask extends Item {

    private int quantity;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public EstusFlask(String name, char displayChar, boolean portable) {
        super(name, 'E', true);
    }

    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }

    /**
     * Set value of quantity
     *
     * @param quantity - id of the bid
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get value of quantity
     *
     * @return value of quantity
     */

    public int getQuantity() {
        return quantity;
    }
}
