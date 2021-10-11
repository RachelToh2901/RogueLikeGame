package game.worldmap;

import java.util.HashMap;

public class MapsManager {

  private HashMap<String, Worldmap> mapList;

  /**
   * Constructor
   */
  public MapsManager(){
    mapList = new HashMap<>() {
    };

  }

  public void addMap(Worldmap worldmap) {
    mapList.put(worldmap.getName(),worldmap);
  }

  public Worldmap getMap(String name) {
    return mapList.get(name);
  }

  public void spawnFogDoor() {
    for (Worldmap worldMap : mapList.values()) {
      worldMap.spawnFogDoor();
    }
  }
}
