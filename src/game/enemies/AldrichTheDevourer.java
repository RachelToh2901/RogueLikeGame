package game.enemies;

import edu.monash.fit2099.engine.*;
import game.behaviors.EnragedBossFollowBehavior;
import game.interfaces.Behaviour;
import game.items.CindersOfALord;
import game.weapons.DarkmoonLongBow;
import game.weapons.YhormsGiantMachete;

import static game.enums.Status.STUNNED;

public class AldrichTheDevourer extends Enemies{

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param soulReward
     */
    public AldrichTheDevourer(String name, char displayChar, int hitPoints, int soulReward) {
        super("Aldrich The Devourer", 'A', 350, 5000);
        behaviours.clear();
        addItemToInventory(new CindersOfALord());
        addItemToInventory(new DarkmoonLongBow());
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

        // Status check
        if ( this.hasCapability(STUNNED)) {
            removeCapability(STUNNED);
            return new DoNothingAction();
        }

        // Attacks player whenever possible
        if ( checkIsPlayerNear(actions) ) {
            return attackPlayer(actions);
        }

        // loop through all behaviours
        for(game.interfaces.Behaviour Behaviour : behaviours) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }

        return new DoNothingAction();
    }

    /**
     * Method to reset abilities, items and attributes of Aldrich the Devourer
     * @param map - the map containing Lord of Cinder
     */
    @Override
    public void resetInstance(GameMap map) {
        this.hitPoints = maxHitPoints;
        behaviours.removeIf(behaviour -> behaviour instanceof EnragedBossFollowBehavior);
        if ( initialLocation != null ) {
            map.moveActor(this, initialLocation);
        }
    }
}
