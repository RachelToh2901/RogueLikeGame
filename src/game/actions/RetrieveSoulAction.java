package game.actions;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.items.TokenOfSouls;

public class RetrieveSoulAction extends Action {

    private TokenOfSouls tokenOfSouls;
    private int numOfSouls;

    public RetrieveSoulAction(TokenOfSouls tokenOfSouls){
        this.tokenOfSouls = tokenOfSouls;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // Question : Do we need to check whether actor is player?
            numOfSouls = tokenOfSouls.getNumberOfSouls();
            ((Player) actor).addSouls(numOfSouls);
            map.locationOf(actor).removeItem(tokenOfSouls);
            return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has retrieved " + numOfSouls + " number of Souls";
    }
}
