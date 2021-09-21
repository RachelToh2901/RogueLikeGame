package game.activeSkills;

import edu.monash.fit2099.engine.*;

public class BurnGroundAction extends WeaponAction {
    /**
     * Constructor
     *
     * @param weaponItem the weapon item that has capabilities
     */
    public BurnGroundAction(WeaponItem weaponItem) {
        super(weaponItem);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        //TODO - not yet implement
        int damage = weapon.damage();
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
                        map.removeActor(target);
                        result += System.lineSeparator() + target + " is killed." + System.lineSeparator();
                    }
                }
            }
        }
        return result;

    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
