package game.actions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.items.EstusFlask;

public class DrinkEstusFlaskAction extends Action {

    private EstusFlask estusFlask;
    private int maxhp;

    /**
     * Set value of maxhp
     *
     * @param maxhp- maximum hit points of player
     */
    public void setMaxHp(int maxhp) {
        this.maxhp = maxhp;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        int chargesLeft = estusFlask.getChargesLeft();
        if(chargesLeft >= 1){
            actor.heal((40/100)*maxhp);
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
}


