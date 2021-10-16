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
        allowableActions.add(new SpinAttackAction(this));
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
