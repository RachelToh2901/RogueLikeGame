package game.worldmap;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.World;
import game.BonFireManager;
import game.grounds.Bonfire;

import java.util.Locale;

public abstract class Worldmap {

  protected String name;
  protected GameMap map;
  protected World world;
  protected Bonfire bonfire;
  protected BonFireManager bonFireManager;
  protected MapsManager mapsManager;
  protected Location fogDoorLocation;

  public Worldmap(String name, World world, BonFireManager bonFireManager, MapsManager mapsManager) {
    this.name = name;
    this.world = world;
    this.bonFireManager = bonFireManager;
    this.mapsManager = mapsManager;
  }

  public void spawnEnemies(){}

  public String getName() {
    return name;
  }

  public GameMap getGameMap() {
    return map;
  }

  public void spawnFogDoor(){};

  public void spawnBonfire(){};

  public Location getFogDoorLocation(){return fogDoorLocation;};
}

