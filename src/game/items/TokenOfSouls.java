package game.items;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.actions.RetrieveSoulAction;

import java.util.List;

public class TokenOfSouls extends Item {

    private int numberOfSouls;
    public Location itemLocation;

    public TokenOfSouls(Actor actor) {
        super("Token of Souls", '$', true);
        itemLocation = ((Player) actor).getLastLocation();
        numberOfSouls = ((Player) actor).getSouls();
    }


    @Override
    public List<Action> getAllowableActions() {
        this.allowableActions.add(new RetrieveSoulAction(this));
        return allowableActions.getUnmodifiableActionList();
    }

    public int getNumberOfSouls() {
        return numberOfSouls;
    }

    public Location getItemLocation(){
        return itemLocation;
    }
}
