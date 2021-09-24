package game.items;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
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
