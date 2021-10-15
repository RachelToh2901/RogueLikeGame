package game.items;

import edu.monash.fit2099.engine.*;
import game.actions.InvisibleAction;

import java.util.List;

import static game.enums.Status.INVISIBLE;

public class InvisibleCloak extends Item {

    private int tickCount;
    private boolean isUsing;

    /***
     * Constructor.
     */
    public InvisibleCloak() {
        super("Invisible Cloak", '?', false);
        tickCount = 0;
        isUsing = false;
        allowableActions.add(new InvisibleAction(this));
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (isUsing){
            tickCount++;
        }
        if (getTickCount() == 3){
            actor.removeCapability(INVISIBLE);
            resetTickCount();
            isUsing = false;
        }
    }

    public int getTickCount() {
        return tickCount;
    }

    public void resetTickCount(){
        tickCount = 0;
    }

    public void actorUsing(){
        isUsing = true;
    }


}
