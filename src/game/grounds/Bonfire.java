package game.grounds;

import edu.monash.fit2099.engine.*;
import game.BonFireManager;
import game.actions.LitBonfire;
import game.actions.ResetAction;

import java.util.HashMap;

/**
 * Class to create a new Bonfire where Player can rest
 */
public class Bonfire extends Ground {

    private BonFireManager bonFireManager;
    private boolean lit = false;
    private String name;

    /**
     * Constructor.
     *
     */
    public Bonfire(String name) {
        super('B');
        this.name = name;
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
        if (lit) {
            actions.add(new ResetAction());

            HashMap<Bonfire, Location> bonfireArr = bonFireManager.getTeleportable();
            for ( Bonfire bonfire : bonfireArr.keySet()) {
                if ( bonfire != this && bonfire.lit ) {
                    actions.add( new MoveActorAction(bonfireArr.get(bonfire), "to " + bonfire.name));
                }
            }
        } else  {
            actions.add(new LitBonfire(this));
        }

        return actions;
    }

    public void setBonFireManager(BonFireManager bonFireManager, Location location) {
        this.bonFireManager = bonFireManager;
        bonFireManager.registerBonfire(this, location);
    }

    public void litBonfire() {
        this.lit = true;
    }

    public String getName() {
        return name;
    }
}
