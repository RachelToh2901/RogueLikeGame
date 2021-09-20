package game.items;

import edu.monash.fit2099.engine.*;
import game.actions.DrinkEstusFlaskAction;

import java.util.List;

public class EstusFlask extends Item {

    private int totalCharges;
    private int chargesLeft;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public EstusFlask(String name, char displayChar, boolean portable) {
        super("Estus Flask", 'E', true);
        this.totalCharges = 3;
        this.chargesLeft = 3;
    }

    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }

    /**
     * Set value of totalCharges
     *
     * @param totalCharges- total number of charges of the estus flask
     */
    public void setTotalCharges(int totalCharges) {
        this.totalCharges = totalCharges;
    }

    /**
     * Get value of totalCharges
     *
     * @return value of totalCharges
     */

    public int getTotalCharges() {
        return totalCharges;
    }

    /**
     * Set value of chargesLeft
     *
     * @param chargesLeft- number of charges of the estus flask that the player has left
     */
    public void setChargesLeft(int chargesLeft) {
        this.chargesLeft = chargesLeft;
    }

    /**
     * Get value of chargesLeft
     *
     * @return value of chargesLeft
     */

    public int getChargesLeft() {
        return chargesLeft;
    }

    @Override
    public List<Action> getAllowableActions() {
        allowableActions.add(new DrinkEstusFlaskAction());
        return allowableActions.getUnmodifiableActionList();
    }
}
