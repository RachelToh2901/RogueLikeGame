package game.enemies;

import edu.monash.fit2099.engine.*;
import game.actions.AttackAction;
import game.behaviors.WanderBehaviour;
import game.behaviors.EnragedBossFollowBehavior;
import game.behaviors.FollowBehaviour;
import game.interfaces.Behaviour;
import game.weapons.YhormsGiantMachete;

/**
 * The boss of Design o' Souls
 * FIXME: This boss is Boring. It does nothing. You need to implement features here.
 * TODO: Could it be an abstract class? If so, why and how?
 */
public class LordOfCinder extends Enemies {

    private boolean emberForm;
    /**
     * Constructor.
     */
    public LordOfCinder() {
        super("Lord of Cinder", 'Y', 500 , 5000);
        behaviours.clear();
        addItemToInventory(new YhormsGiantMachete());
    }

    /**
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return DoNothingAction
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        // Saves initial Location
        if (lastAction == null) {
            setInitialLocation(map.locationOf(this));
        }

        // Feature : Ember Form
        if ( hitPoints <= ( maxHitPoints /2 ) && !emberForm ) {
            enraged();
            display.println("Ember Form Activated");
        }

        // Attacks player whenever possible
        if ( attackPlayer(actions) != null ) {
            return attackPlayer(actions);
        }

        return new DoNothingAction();
    }

    @Override
    public void resetInstance(GameMap map) {
        this.hitPoints = maxHitPoints;
        behaviours.removeIf(behaviour -> behaviour instanceof FollowBehaviour);
        if ( initialLocation != null ) {
            map.moveActor(this, initialLocation);
        }
        emberForm = false;
    }

    @Override
    public Action attackPlayer(Actions actions ) {

        for ( Action action : actions ) {
            if ( action instanceof AttackAction) {
                Actor target = ((AttackAction) action).getTarget();
                behaviours.add(new EnragedBossFollowBehavior(target));
                behaviours.removeIf(behaviour -> behaviour instanceof WanderBehaviour);
                return action;
            }
        }
        return null;
    }

    public void enraged() {
        ((YhormsGiantMachete) getWeapon()).activateEmberForm();
        for ( Behaviour behaviour : behaviours ) {
            if ( behaviour instanceof FollowBehaviour) {
                Actor target = ((FollowBehaviour) behaviour).getTarget();
                behaviours.add(new EnragedBossFollowBehavior(target));
                behaviours.remove(behaviour);
            }
        }

        emberForm = true;
    }
}
