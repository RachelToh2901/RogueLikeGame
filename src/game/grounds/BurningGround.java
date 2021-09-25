package game.grounds;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.enemies.LordOfCinder;

public class BurningGround extends Ground {

    private int turnExisted = 1;

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

        if ( location.getActor() != null ) {
            if ( !(location.getActor() instanceof LordOfCinder)) {
                location.getActor().hurt(25);
            }
        }

    }
}
