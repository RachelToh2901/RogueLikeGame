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

  /**
   * Method to add a bonfire to the bonfireList hashmap
   * @param bonfire The bonfire
   * @param location The location of the Bonfire
   */
  public void registerBonfire(Bonfire bonfire,Location location) {
    bonfireList.put(bonfire, location);
  }

  /**
   * Method that returns a list of Bonfires that the Player can teleport to
   * @return a list of bonfires
   */
  public HashMap<Bonfire, Location> getTeleportable() {
    return bonfireList;
  }
}
