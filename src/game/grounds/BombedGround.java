package game.grounds;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * Class to create Bombed ground when the C4 Bomb is dropped by the Player
 */
public class BombedGround extends Ground {


    /**
     * Constructor.
     */
    public BombedGround() {
        super('x');

    }

    /**
     * Ground can also experience the joy of time.
     * @param location The location of the Ground
     */
    public void tick(Location location){
        System.out.println("test Boomed Ground start");
        location.setGround(new Dirt());
        System.out.println("test Boomed Ground end");

    }
}
