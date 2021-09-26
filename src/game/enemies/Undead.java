package game.enemies;


import edu.monash.fit2099.engine.*;
import game.actions.DieByChanceAction;
import game.behaviors.FollowBehaviour;
import game.interfaces.Behaviour;

import java.util.Random;

/**
 * An undead minion which is an enemy of Design o' Souls
 */
public class Undead extends Enemies {

	/** 
	 * Constructor.
	 * All Undeads are represented by an 'u' and have 30 hit points.
	 * @param name the name of this Undead
	 */
	public Undead(String name) {
		super(name, 'U', 50, 50);
		registerInstance();
	}



	/**
	 * Figure out what to do next.
	 * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// Attacks player whenever possible
		if ( checkIsPlayerNear(actions) ) {
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

	/**
	 * Creates and returns an intrinsic weapon.
	 *
	 * By default, the Actor 'punches' for 5 damage. Override this method to create
	 * an Actor with more interesting descriptions and/or different damage.
	 *
	 * @return a freshly-instantiated IntrinsicWeapon
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(20, "thwacks");
	}

	/**
	 * Method to check if a particular instance is present in the game
	 * @return the existence of the instance in the game.
	 *
	 */
	@Override
	public boolean isExist() {
		return false;
	}
}
