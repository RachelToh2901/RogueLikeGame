package game.grounds;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.actions.ResetAction;
import game.enemies.Enemies;
import game.enemies.LordOfCinder;
import game.interfaces.Soul;

/**
 * Class to create burning ground when Lord of cinder activates Ember Form
 */
public class BurningGround extends Ground {

    /**
     * Number of turns for which Ember Form of Lord of Cinder has been activated
     */
    private int turnExisted = 0;

    /**
     * Constructor.
     *
     */
    public BurningGround() {
        super('v');
    }

    /**
     * Ground can also experience the joy of time.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        turnExisted ++;
        if ( turnExisted > 3) {
            System.out.println("test Burning Ground start");
            location.setGround(new Dirt());
            System.out.println("test Burning Ground end");
        }

        if ( location.getActor() != null ) {
            if ( !(location.getActor() instanceof LordOfCinder)) {
                location.getActor().hurt(25);
            }
        }

    }
}
