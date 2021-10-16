package game.behaviors;

import edu.monash.fit2099.engine.*;
import game.CleanBattleField;
import game.interfaces.Behaviour;
import java.util.Random;

/**
 * Class that will implement the ranged attack behaviour of Aldrich the Devourer
 */
public class RangedAttackBehaviour extends Action implements Behaviour {

    /**
     * The actor to be followed and attacked
     */
    private Actor target;

    /**
     * Constructor
     * @param subject The target to be attacked
     */
    public RangedAttackBehaviour(Actor subject){ this.target = subject;}

    /**
     * Creating an action to attack the target
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return an Action that actor can perform, or null if actor can't do this.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        NumberRange xs, ys;

        int diffInX = Math.abs(here.x() - there.x());
        int diffInY = Math.abs(here.y() - there.y());

        if (diffInX <= 3 && diffInY <=3){
            xs = new NumberRange(here.x() + 1, Math.abs(here.x() - there.x()) + 1);
            ys = new NumberRange(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);

            for (int x : xs) {
                for (int y : ys) {
                    if(map.at(x, y).getGround().blocksThrownObjects())
                        return null;
                }
            }
            return this;
        }
        return null;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Weapon weapon = actor.getWeapon();
        Random rand = new Random();

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();

        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

        target.hurt(damage);
        result += CleanBattleField.cleanBattle(actor, map, target);
        return result;
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return a string message of actor executing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " shoots " + target;
    }
}
