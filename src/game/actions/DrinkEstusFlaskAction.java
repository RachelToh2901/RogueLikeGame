package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.items.EstusFlask;
import game.actors.Player;

public class DrinkEstusFlaskAction extends Action {

    private EstusFlask estusFlask;


    @Override
    public String execute(Actor actor, GameMap map) {
        int maxHitPoints = Player.getHitPoints();
        int chargesLeft = estusFlask.getChargesLeft();
        if(chargesLeft >= 1){
            actor.heal((40/100)*maxHitPoints);
            chargesLeft =- 1;
        }
        else{
            System.out.println("Estus Flask doesn't have any charges left");
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "drinks" + estusFlask + "(" + estusFlask.getChargesLeft() + "/" + estusFlask.getTotalCharges() + ")";
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     *
     * @return The key we use for this Action in the menu, or null to have it assigned for you.
     */
    public String hotkey() {
        return "a";
    }
}


