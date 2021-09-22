package game.items;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.actions.RetrieveSoulAction;

import java.util.List;

public class TokenOfSouls extends Item {

    private int numberOfSouls;
    public Location itemLocation;

    public TokenOfSouls(Player player) {
        super("Token of Souls", '$', true);
    }

    @Override
    public DropItemAction getDropAction(Actor actor) {
        if (!actor.isConscious()){
            itemLocation = ((Player) actor).getLastSavedLocation();
            numberOfSouls = ((Player) actor).getSouls();
            return super.getDropAction(actor);
        }
        return null;
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
