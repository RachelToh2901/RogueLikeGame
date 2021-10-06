package game.activeSkills;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.ResetManager;
import game.enemies.Enemies;
import game.enemies.LordOfCinder;
import game.interfaces.Soul;

import java.util.Random;

import static game.enums.Status.STUNNED;

/**
 * Special Action for Storm Ruler
 */
public class WindSlashAction extends WeaponAction{

    /**
     * The Actor that is to be attacked
     */
    protected Actor target;

    /**
     * The direction of incoming attack.
     */
    protected String direction;

    /**
     * Constructor
     * @param weaponItem the weapon item that has capabilities
     */
    public WindSlashAction(WeaponItem weaponItem) {
        super(weaponItem);
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    public String execute(Actor actor, GameMap map) {

        String result = "";
        int damage = weapon.damage();
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits())
            if (exit.getDestination().containsAnActor()) {
                Location targetLocation = exit.getDestination();
                Actor target = map.getActorAt(targetLocation);
                boolean isAttack = false;
                if (target instanceof LordOfCinder) {
                    damage *= 2;
                    result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage." + System.lineSeparator() ;
                    isAttack = true;
                }else {
                    Random rand = new Random();
                    if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                        return actor + " misses " + target + ".";
                    }
                }
                if (isAttack) {
                    target.hurt(damage);
                    target.addCapability(STUNNED);
                    //reset the number of charge after using this skill
                    ChargeAction.resetNumOfCharge();
                    if (!target.isConscious()) {
                        // drop all items
                        Actions dropActions = new Actions();
                        for (Item item : target.getInventory())
                            dropActions.add(item.getDropAction(actor));
                        for (Action drop : dropActions)
                            drop.execute(target, map);

                        if (target instanceof Player) {
                            // TODO : COMPLETE IT
                            ResetManager.getInstance().run(map);
                        } else {
                            ((Enemies) target).die(map, (Soul) actor);
                        }

                        result += System.lineSeparator() + target + " is killed." + System.lineSeparator();
                    }
                }

            }
        return result;
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    public String menuDescription(Actor actor) {
        return actor + " uses Wind Slash with " + weapon;
    }
}
