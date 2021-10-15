package game.grounds;

import edu.monash.fit2099.engine.*;
import game.CleanBattleField;

import static game.enums.Status.STUNNED;

/**
 * Class to create Bombed ground when the C4 Bomb is dropped by the Player
 */
public class BombedGround extends Ground {

    private static int tickCount = 0;
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

        if (getTickCount() >4){
            if (location.containsAnActor()){
                Actor target = location.getActor();
                target.hurt(50);
                Display display = new Display();
                display.println(target + " is boooommedd. 50 hp deducted.");
                String result = CleanBattleField.cleanBattle(player, map, target);
                if (target.isConscious()){
                    target.addCapability(STUNNED);
                }else{
                    display.println(result);
                }

            }
            location.setGround(new Dirt());
        }

        if (getTickCount() >= 13){
            tickCount = 0;
        }
    }

    public static int getTickCount(){
        return tickCount;
    }
}
