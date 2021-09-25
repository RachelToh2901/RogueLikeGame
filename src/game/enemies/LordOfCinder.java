package game.enemies;

import edu.monash.fit2099.engine.*;
import game.actions.AttackAction;
import game.behaviors.WanderBehaviour;
import game.behaviors.EnragedBossFollowBehavior;
import game.behaviors.FollowBehaviour;
import game.interfaces.Behaviour;
import game.items.CindersOfALord;
import game.weapons.YhormsGiantMachete;

/**
 * The boss of Design o' Souls
 * FIXME: This boss is Boring. It does nothing. You need to implement features here.
 * TODO: Could it be an abstract class? If so, why and how?
 */
public class LordOfCinder extends Enemies {

    /**
     * Variable to check if Lord of Cinder is in ember form or not
     */
    private boolean emberForm;

    /**
     * Constructor.
     */
    public LordOfCinder() {
        super("Lord of Cinder", 'Y', 500 , 5000);
        behaviours.clear();
        addItemToInventory(new YhormsGiantMachete());
        addItemToInventory(new CindersOfALord());
        registerInstance();
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
        if ( initialLocation == null ) {
            setInitialLocation(map.locationOf(this));
        }

        // Feature : Ember Form
        if ( hitPoints <= ( maxHitPoints /2 ) && !emberForm ) {
            enraged();
            display.println("Ember Form Activated");
        }

        // Attacks player whenever possible
        if ( checkIsPlayerNear(actions) ) {
            return attackPlayer(actions);
        }

        // loop through all behaviours
        for(Behaviour Behaviour : behaviours) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }

        return new DoNothingAction();
    }

    /**
     * Method to reset abilities, items and attributes of Lord of Cinder
     * @param map - the map containing Lord of Cinder
     */
    @Override
    public void resetInstance(GameMap map) {
        this.hitPoints = maxHitPoints;
        behaviours.removeIf(behaviour -> behaviour instanceof EnragedBossFollowBehavior);
        if ( initialLocation != null ) {
            map.moveActor(this, initialLocation);
        }
        emberForm = false;
    }

    /**
     * Method for Lord of Cinder to attack player
     * @param actions list of actions
     */
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

    /**
     * Method for Lord of Cinder to attack player in ember form(enraged)
     *
     */
    public void enraged() {
        ((YhormsGiantMachete) getWeapon()).activateEmberForm();
        Actor target = null;
        for ( int i = 0; i < behaviours.size(); i ++ ) {
            if ( behaviours.get(i) instanceof FollowBehaviour) {
//                target = ((FollowBehaviour) behaviour).getTarget();
                target = ((FollowBehaviour) behaviours.get(i)).getTarget();
                behaviours.set(i,new EnragedBossFollowBehavior(target));
            }
        }


        emberForm = true;
    }
}
