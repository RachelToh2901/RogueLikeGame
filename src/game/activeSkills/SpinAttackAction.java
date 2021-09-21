package game.activeSkills;

import edu.monash.fit2099.engine.*;
import game.enums.Abilities;

public class SpinAttackAction extends WeaponAction {

    /**
     * Constructor
     */
    public SpinAttackAction(WeaponItem weaponItem) {
        super(weaponItem);
    }

    public String execute(Actor actor, GameMap map) {
        int damage = weapon.damage() / 2;
        Location actorLocation = map.locationOf(actor);
        int xCord = actorLocation.x();
        int yCord = actorLocation.y();
        String result = "";
        for (int i = -1; i<=1; i++){
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0){
                    break;
                }
                int newXCord = xCord + i;
                int newYCord = yCord + i;
                Location targetLocation = new Location(map, newXCord, newYCord);
                if (map.isAnActorAt(targetLocation)) {
                    Actor target = map.getActorAt(targetLocation);
                    result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
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
                        //TODO: In A1 scenario, you must not remove a Player from the game yet. What to do, then?
                        map.removeActor(target);
                        result += System.lineSeparator() + target + " is killed." + System.lineSeparator();
                }
            }
        }
        }
        return result;
    }

    public String menuDescription(Actor actor) {
        return actor + " uses spin attack with " + weapon;
    }

}
