package game.grounds;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.NameGenerator;
import game.enemies.Undead;

import java.util.List;
import java.util.Random;

public class Cemetery extends Ground {
    /**
     * Constructor.
     *
     */
    public Cemetery() {
        super('c');
    }

    @Override
    public void tick(Location location) {
        Random rand = new Random();
        if ( rand.nextInt(100) < 25 ) {
            List<Exit> exits = location.getExits();
            int direction = rand.nextInt(exits.size());
            Location there = exits.get(direction).getDestination();
            there.addActor(new Undead(NameGenerator.getInstance().generateName()+ "the Undead" ));
        }
    }
}
