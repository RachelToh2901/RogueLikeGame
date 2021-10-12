package game.items;

import edu.monash.fit2099.engine.*;
import game.cleanBattleField;
import game.grounds.BombedGround;
import game.grounds.Dirt;

/**
 * Class for C4 Bomb which is an item that can be purchased from the Vendor
 */
public class C4Bomb extends Item {

    /**
     * Number of turns that the bombed ground has lasted
     */
    private int turnExisted;

    /**
     * Player who drops the bomb
     */
    private Actor player;

    /**
     * Damage caused by the bomb
     */
    private int bombDamage = 50;

    /**
     * Boolean variable that checks if the bomb has already been dropped
     */
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

    /**
     * Create and return an action to pick this Item up.
     * If this Item is not portable, returns null.
     *
     * @param actor an actor that will interact with this item
     * @return a new PickUpItemAction if this Item is portable, null otherwise.
     */
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return null;
    }

    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */
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

    /**
     * Method to simulate bombing when the C4 bomb is droppee by the Player
     * @param currentLocation Location where the bomb is dropped
     */
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
