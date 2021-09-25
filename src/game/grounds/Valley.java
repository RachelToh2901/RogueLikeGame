package game.grounds;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.Player;
import game.ResetManager;
import game.actions.ResetAction;
import game.items.TokenOfSouls;

/**
 * The gorge or endless gap that is dangerous for the Player.
 */
public class Valley extends Ground {

	/**
	 * Constructor.
	 *
	 */
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
		return actor instanceof Player;
	}

	/**
	 * Ground can also experience the joy of time.
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location) {
		Actor actorStandingOn = location.getActor();
		if ( actorStandingOn instanceof Player ) {
			Action action = new ResetAction();
			actorStandingOn.hurt(((Player) actorStandingOn).getMaxHitPoints());
			action.execute(actorStandingOn, location.map());
		}

	}
}
