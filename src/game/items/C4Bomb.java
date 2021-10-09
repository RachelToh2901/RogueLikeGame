package game.items;

import edu.monash.fit2099.engine.*;
import game.cleanBattleField;
import game.grounds.BombedGround;
import game.grounds.Dirt;

public class C4Bomb extends Item {

    private int turnExisted;
    private Actor player;
    private int bombDamage = 50;
    private boolean hasBombed;

    /***
     * Constructor.
     * @param actor actor who will buy this C4Bomb
     */
    public C4Bomb(Actor actor) {
        super("C4Bomb", 'X', true);
        player = actor;
        turnExisted = 0;
        hasBombed = false;
    }

    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return null;
    }

    @Override
    public void tick(Location currentLocation) {
        if (!player.getInventory().contains(this)){
            turnExisted += 1;
        }
        if (turnExisted >= 3){
            bombing(currentLocation);
            turnExisted = 0;
            currentLocation.removeItem(this);
//            hasBombed = true;
        }

    }

    public void bombing(Location currentLocation){
        Display display = new Display();
        display.println("Ka-BOOOOOOOOMMMMMMMM");
        currentLocation.setGround(new BombedGround());
        GameMap map = currentLocation.map();
        int damage = bombDamage;
        String result = "";
        currentLocation.setGround(new BombedGround());
        for (Exit exit : currentLocation.getExits()) {
            Ground currentGround = exit.getDestination().getGround();
            if (currentGround instanceof Dirt || currentGround instanceof BombedGround){
                exit.getDestination().setGround(new BombedGround());
            }
            if (exit.getDestination().containsAnActor()) {
                Actor target = exit.getDestination().getActor();
                target.hurt(damage);
                result += target + " is boooommedd. 50 hp deducted." + System.lineSeparator();
                result += cleanBattleField.cleanBattle(player, map, target);

            }
        }
        display.println(result);
    }


}
