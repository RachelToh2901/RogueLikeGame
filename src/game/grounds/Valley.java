package game.grounds;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.Player;
import game.ResetManager;
import game.actions.ResetAction;

/**
 * The gorge or endless gap that is dangerous for the Player.
 */
public class Valley extends Ground {

	public Valley() {
		super('+');
	}

	/**
	 * FIXME: At the moment, the Player cannot enter it. It is boring.
	 * @param actor the Actor to check
	 * @return false or actor cannot enter.
	 */
	@Override
	public boolean canActorEnter(Actor actor){
		return false;
	}

	@Override
	public void tick(Location location) {
		Actor actorStandingOn = location.getActor();
		if ( actorStandingOn instanceof Player ) {
			Action action = new ResetAction();
			actorStandingOn.hurt(9999);
			action.execute(actorStandingOn, location.map());
		}

	}
}
