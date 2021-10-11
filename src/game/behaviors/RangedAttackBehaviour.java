package game.behaviors;

import edu.monash.fit2099.engine.*;
import game.cleanBattleField;
import game.interfaces.Behaviour;

import java.util.Random;

public class RangedAttackBehaviour extends Action implements Behaviour {

    private Actor target;

    public RangedAttackBehaviour(Actor subject){ this.target = subject;}

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
        result += cleanBattleField.cleanBattle(actor, map, target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " shoots " + target;
    }
}
