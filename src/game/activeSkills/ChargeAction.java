package game.activeSkills;

import edu.monash.fit2099.engine.*;

public class ChargeAction extends WeaponAction {
    protected static int numOfCharge = 0;

    public ChargeAction(WeaponItem weaponItem) {
        super(weaponItem);
    }

    public String execute(Actor actor, GameMap map) {
        numOfCharge += 1;
        return actor + " charged Storm Ruler";
    }

    public String menuDescription(Actor actor) {
        return String.format("%s charges Storm Ruler (%d/3)", actor, numOfCharge);
    }

    public static int getNumOfCharge() {
        return numOfCharge;
    }

    public static void resetNumOfCharge(){
        numOfCharge = 0;
    }
}
