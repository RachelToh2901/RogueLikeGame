package game.actions;

import edu.monash.fit2099.engine.*;
import game.BonFireManager;
import game.Player;
import game.grounds.Bonfire;

public class TeleportToBonfireAction extends MoveActorAction {

    private Bonfire bonfire;
    private BonFireManager bonFireManager;

    public TeleportToBonfireAction(Location moveToLocation, String direction, Bonfire bonfire, BonFireManager bonFireManager) {
        super(moveToLocation, direction);
        this.bonFireManager = bonFireManager;
        this.bonfire = bonfire;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        super.execute(actor, map);
        bonFireManager.setLastInteractedBonfire(bonfire);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports to " + direction ;
    }
}
