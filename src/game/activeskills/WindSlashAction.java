package game.activeskills;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class WindSlashAction extends WeaponAction{
    protected Actor target;
    protected String direction;

    public WindSlashAction(WeaponItem weaponItem, Actor target, String direction) {
        super(weaponItem);
        this.target = target;
        this.direction = direction;
    }

    public String execute(Actor actor, GameMap map) {

        String result = "";
        char yhormTheGiantChar = 'Y';
        int compareChar = Character.compare(target.getDisplayChar(), yhormTheGiantChar);
        int damage = weapon.damage();
        if (compareChar == 0) {
            damage *= 2;
        }else {
            Random rand = new Random();
            if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                return actor + " misses " + target + ".";
            }
        }
        result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            /** if actor is player
             * 		reward =  rewardsystem ( target)
             * 		player.addSouls(reward)
             */
            Actions dropActions = new Actions();
            // drop all items
            for (Item item : target.getInventory())
                dropActions.add(item.getDropAction(actor));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            result += System.lineSeparator() + target + " is killed.";
        }
        //reset the number of charge after using this skill
        ChargeAction.resetNumOfCharge();
        return result;
    }

    public String menuDescription(Actor actor) {
        return actor + " uses Wind Slash with " + weapon;
    }
}
