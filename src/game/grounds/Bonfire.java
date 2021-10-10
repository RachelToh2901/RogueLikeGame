package game.grounds;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.actions.ResetAction;

/**
 * Class to create a new Bonfire where Player can rest
 */
public class Bonfire extends Ground {

    /**
     * Constructor.
     *
     */
    public Bonfire() {
        super('B');
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = new Actions();
        actions.add(new ResetAction());
        return actions;
    } 
}
