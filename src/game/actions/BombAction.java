//package game.actions;
//
//import edu.monash.fit2099.engine.*;
//import game.grounds.BombedGround;
//
//public class BombAction extends Action {
//
//    private Item bomb;
//
//    public BombAction(Item item){
//        this.bomb = item;
//    }
//
//    @Override
//    public String execute(Actor actor, GameMap map) {
//        currentLocation.setGround(new BombedGround());
//        for (Exit exit: currentLocation.getExits()){
//            Location destination = exit.getDestination();
//            destination.setGround(new BombedGround());
//            if (destination.containsAnActor()){
//                destination.getActor().hurt(50);
//            }
//        }
//    }
//
//    @Override
//    public String menuDescription(Actor actor) {
//        return null;
//    }
//}
