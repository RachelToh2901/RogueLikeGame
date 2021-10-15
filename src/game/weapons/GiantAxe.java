package game.weapons;

import edu.monash.fit2099.engine.Action;
import game.activeskills.SpinAttackAction;

import java.util.List;

/**
 * Class for Giant Axe weapon
 */
public class GiantAxe extends MeleeWeapon {

    /**
     * Constructor
     */
    public GiantAxe () {
        super("Giant Axe", 'T', 50, "flink", 80);
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
            if (action instanceof SpinAttackAction) {
                present = true;
                break;
            }
        }
        if(!present){
            allowableActions.add(new SpinAttackAction(this));
        }
        return allowableActions.getUnmodifiableActionList();
    }

    /**
     * Method that returns a descriptive string
     * @return a descriptive string
     */
    @Override
    public String toString() {
        return "Giant Axe";
    }
}
