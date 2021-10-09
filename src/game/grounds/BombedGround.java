package game.grounds;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class BombedGround extends Ground {


    /**
     * Constructor.
     */
    public BombedGround() {
        super('x');

    }

    public void tick(Location location){
        System.out.println("test Boomed Ground start");
        location.setGround(new Dirt());
        System.out.println("test Boomed Ground end");

    }
}
