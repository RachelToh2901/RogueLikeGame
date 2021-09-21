package game.enemies;


import edu.monash.fit2099.engine.*;
import game.actions.AttackAction;
import game.actions.DieByChanceAction;
import game.behaviors.FollowBehaviour;
import game.enums.Status;
import game.interfaces.Behaviour;

import java.util.Random;

/**
 * An undead minion.
 */
public class Undead extends Enemies {
	// OLD CODE
	// Will need to change this to a collection if Undeads gets additional Behaviours.
	// private ArrayList<Behaviour> behaviours = new ArrayList<>();

	/** 
	 * Constructor.
	 * All Undeads are represented by an 'u' and have 30 hit points.
	 * @param name the name of this Undead
	 */
	public Undead(String name) {
		super(name, 'u', 50, 50);
		// OLD CODE
		// behaviours.add(new WanderBehaviour());
	}

	/**
	 * At the moment, we only make it can be attacked by enemy that has HOSTILE capability
	 * You can do something else with this method.
	 * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return list of actions
	 * @see Status#HOSTILE_TO_ENEMY
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		// it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
		if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			actions.add(new AttackAction(this,direction));
		}
		return actions;
	}

	/**
	 * Figure out what to do next.
	 * FIXME: An Undead wanders around at random and it cannot attack anyone. Also, figure out how to spawn this creature.
	 * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// Attacks player whenever possible
		if ( attackPlayer(actions) != null ) {
			return attackPlayer(actions);
		}

		// loop through all behaviours
		for(Behaviour Behaviour : behaviours) {

			// Feature : 10% to die every turn
			if ( !(Behaviour instanceof FollowBehaviour) ) {
				Random rand = new Random();
				if ( rand.nextInt(100) < 10 ) {
					return new DieByChanceAction();
				}
			}

			// Executing all behavior actions
			Action action = Behaviour.getAction(this, map);
			if (action != null)
				return action;
		}


		return new DoNothingAction();
	}

	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(20, "thwacks");
	}

	@Override
	public boolean isExist() {
		return false;
	}
}
