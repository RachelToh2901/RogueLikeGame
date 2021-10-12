package game.grounds;

import edu.monash.fit2099.engine.*;
import game.cleanBattleField;
import game.items.C4Bomb;

/**
 * Class to create Bombed ground when the C4 Bomb is dropped by the Player
 */
public class BombedGround extends Ground {

    private static int tickCount;
    private Actor player;
    private GameMap map;


    /**
     * Constructor.
     */
    public BombedGround(Actor player, GameMap map) {
        super('x');
        this.player = player;
        this.map = map;
    }

    /**
     * Ground can also experience the joy of time.
     * @param location The location of the Ground
     */
    public void tick(Location location){
        tickCount++;
        if (getTickCount()>4){
            location.setGround(new Dirt());
        }
        else if (location.containsAnActor()){
            Actor target = location.getActor();
            target.hurt(50);
            Display display = new Display();
            display.println(target + " is boooommedd. 50 hp deducted." + System.lineSeparator());
            String result = cleanBattleField.cleanBattle(player, map, target);
            if (result.length() >0){
                display.println(result);
            }
        }
    }

    public static int getTickCount(){
        return tickCount;
    }
}
