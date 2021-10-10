package game.items;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import game.Player;
import game.actions.RetrieveSoulAction;

import java.util.List;

/**
 * Class for Token of Souls which the Player can interact with to retrieve souls that were lost when the player died
 */
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
     * @param actor actor who will spawn Token
     */
    public TokenOfSouls(Actor actor) {
        super("Token of Souls", '$', false);
        itemLocation = ((Player) actor).getLastLocation();
        numberOfSouls = ((Player) actor).getSouls();
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
        boolean present = false;
        for(Action action: allowableActions) {
            if (action instanceof RetrieveSoulAction) {
                present = true;
                break;
            }
        }
        if(!present){
            allowableActions.add(new RetrieveSoulAction(this));
        }
        return allowableActions.getUnmodifiableActionList();
    }

    /**
     * Getter
     * @return numberOfSouls - number of souls the PLayer has
     */
    public int getNumberOfSouls() {
        return numberOfSouls;
    }

}
