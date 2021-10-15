package game;

import edu.monash.fit2099.engine.Location;
import game.grounds.Bonfire;

import java.util.HashMap;

public class BonFireManager {

  /**
   * Creating new hashmap
   */
  private HashMap<Bonfire, Location> bonfireList;

  /**
   * Constructor
   */
  public BonFireManager(){
    bonfireList = new HashMap<>();

  }

  public void registerBonfire(Bonfire bonfire,Location location) {
    bonfireList.put(bonfire, location);
  }

  public HashMap<Bonfire, Location> getTeleportable() {
    return bonfireList;
  }
}
