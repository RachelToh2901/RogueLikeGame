package game.items;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.actions.RetrieveSoulAction;

import java.util.List;

public class TokenOfSouls extends Item {

    /**
     * Number of souls that the player has
     */
    private int numberOfSouls;

    /**
     * Location of token of souls
     */
    public Location itemLocation;

    /**
     * Constructor.
     *
     * @param player - Player of the game
     */
    public TokenOfSouls(Player player) {
        super("Token of Souls", '$', true);
    }

    /**
     * In this game,
     * @param actor an actor that will interact with this item
     * @return null because
     */
    @Override
    public DropItemAction getDropAction(Actor actor) {
        if (!actor.isConscious()){
            itemLocation = ((Player) actor).getLastSavedLocation();
            numberOfSouls = ((Player) actor).getSouls();
            return super.getDropAction(actor);
        }
        return null;
    }

    /**
     * Getter.
     *
     * Returns an unmodifiable copy of the actions list so that calling methods won't
     * be able to change what this Item can do without the Item checking.
     * @return an unmodifiable list of Actions
     */
    @Override
    public List<Action> getAllowableActions() {
        this.allowableActions.add(new RetrieveSoulAction(this));
        return allowableActions.getUnmodifiableActionList();
    }

    /**
     * Get value of numberOfSouls
     *
     * @return value of numberOfSouls
     */
    public int getNumberOfSouls() {
        return numberOfSouls;
    }

    /**
     * Get value of itemLocation
     *
     * @return value of itemLocation
     */
    public Location getItemLocation(){
        return itemLocation;
    }
}
