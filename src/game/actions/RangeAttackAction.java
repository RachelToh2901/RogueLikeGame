package game.actions;

import edu.monash.fit2099.engine.*;

public class RangeAttackAction extends Action {

  private Actor target;

  public RangeAttackAction(Actor target) {
    this.target = target;
  }

  @Override
  public String execute(Actor actor, GameMap map) {;

    Location here = map.locationOf(actor);
    Location there = map.locationOf(target);


    int diffInX = Math.abs(here.x() - there.x());
    int diffInY = Math.abs(here.y() - there.y());
    NumberRange xs, ys;

    if ( diffInX == 0 ){
      xs = new NumberRange(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
    } else if ( diffInX == 1 ) {
      xs = new NumberRange(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
    } else  {
      xs = new NumberRange(Math.min(here.x(), there.x()) + 1, Math.abs(here.x() - there.x()) - 1 );
    }

    if ( diffInY == 0 ){
      ys = new NumberRange(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1 );
    } else if ( diffInY == 1 ) {
      ys = new NumberRange(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1 );
    } else  {
      ys = new NumberRange(Math.min(here.y(), there.y()) + 1, Math.abs(here.y() - there.y()) - 1 );
    }

    for (int x : xs) {
      for (int y : ys) {
        if(map.at(x, y).getGround().blocksThrownObjects())
          return actor + " attack is blocked ";
      }
    }

    int damage = actor.getWeapon().damage();
    target.hurt(damage);
    return actor + " shot an arrow at " + target ;
  }

  @Override
  public String menuDescription(Actor actor) {
    return null;
  }
}
