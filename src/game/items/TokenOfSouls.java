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
        super("Token of Souls", '$', false);
        itemLocation = ((Player) actor).getLastLocation();
        numberOfSouls = ((Player) actor).getSouls();
        System.out.println("numberOfSouls in TokenOfSouls: " + numberOfSouls);
    }


    @Override
    public List<Action> getAllowableActions() {
        boolean present = false;
        for(Action action: allowableActions) {
            if (action instanceof RetrieveSoulAction) {
                present = true;
                break;
            }
        }
        if(!present){
            allowableActions.add(new RetrieveSoulAction(this));
        }
        return allowableActions.getUnmodifiableActionList();
    }

    public int getNumberOfSouls() {
        return numberOfSouls;
    }

}
