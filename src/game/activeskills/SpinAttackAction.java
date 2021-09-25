package game.activeskills;

import edu.monash.fit2099.engine.*;
import game.Player;
import game.ResetManager;
import game.enemies.Enemies;
import game.interfaces.Soul;

/**
 * Special Action for Giant Axe
 */
public class SpinAttackAction extends WeaponAction {

    /**
     * Constructor
     * @param weaponItem the weapon item that has capabilities
     */
    public SpinAttackAction(WeaponItem weaponItem) {
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
        Location here = map.locationOf(actor);
//        int xCord = actorLocation.x();
//        int yCord = actorLocation.y();
//        String result = "";
//        for (int i = -1; i<=1; i++) {
//            for (int j = -1; j <= 1; j++) {
//                if (i == 0 && j == 0) {
//                    break;
//                }
//                int newXCord = xCord + i;
//                int newYCord = yCord + i;
//                Location targetLocation = new Location(map, newXCord, newYCord);
//            }
//        }
        String result = "";
        int damage = weapon.damage() / 2;
        for (Exit exit : here.getExits())
            if (exit.getDestination().containsAnActor()) {
                Location targetLocation = exit.getDestination();
                Actor target = map.getActorAt(targetLocation);
                boolean isAttack = false;
                if (actor instanceof Player) {
                    result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage. \n" ;
                    isAttack = true;
                } else if (actor instanceof Enemies && target instanceof Player) {
                    result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
                    isAttack = true;
                }
                if (isAttack) {
                    target.hurt(damage);
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

                        result += target + " is killed." + System.lineSeparator();
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
    public String menuDescription (Actor actor){
        return actor + " uses spin attack with " + weapon;
    }
}
