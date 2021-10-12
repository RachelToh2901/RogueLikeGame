package game.grounds;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.enemies.LordOfCinder;

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
            location.setGround(new Dirt());
        }

        //Note: can use location.containsAnActor()
        if ( location.getActor() != null ) {
            if ( !(location.getActor() instanceof LordOfCinder)) {
                location.getActor().hurt(25);
            }
        }

    }
}
