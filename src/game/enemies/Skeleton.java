package game.enemies;

import edu.monash.fit2099.engine.*;

import game.interfaces.Behaviour;
import game.interfaces.Soul;
import game.weapons.BroadSword;
import game.weapons.GiantAxe;

import java.util.Random;

public class Skeleton extends Enemies {

    private boolean revivedOnce = false;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Skeleton(String name, char displayChar, int hitPoints) {
        super("Skeleton", 's', 100, 250);

        // Equipping Weapon
        Random rand = new Random();
        if ( rand.nextInt(100 ) > 50 ) {
            addItemToInventory(new BroadSword());
        } else {
            addItemToInventory(new GiantAxe());
        }
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        // Saves initial Location
        if (lastAction == null) {
            setInitialLocation(map.locationOf(this));
        }

        // Attacks player whenever possible
        if ( attackPlayer(actions) != null ) {
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

    @Override
    public String die(GameMap map, Soul rewardedActor) {
        if ( !revivedOnce ) {
            Random rand = new Random();
            if ( rand.nextInt(100) < 50 ) {
                this.hitPoints = maxHitPoints;
                this.revivedOnce = true;
                return  this.name + "revived.";
            }
        }

        map.removeActor(this);
        this.transferSouls(rewardedActor);
        return this.name + " has been slain. Gained " + soulReward + " souls.";
    }
}
