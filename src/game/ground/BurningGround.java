package game.ground;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.YhormsGiantMachete;
import game.enemies.LordOfCinder;

public class BurningGround extends Ground {

    // TODO : THINK IF THIS NEEDS TO BE IN WEAPON INSTEAD

    private int turnExisted = 1;
    /**
     * Constructor.
     *
     */
    public BurningGround() {
        super('V');
    }

    @Override
    public void tick(Location location) {
        turnExisted ++;
        if ( turnExisted > 3) {
            location.setGround(new Dirt());
        }

        if ( !(location.getActor() instanceof LordOfCinder)) {
            location.getActor().hurt(25);
        }
    }
}
