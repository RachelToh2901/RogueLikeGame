package game.weapons;

import java.util.Random;

public class BroadSword extends MeleeWeapon {

    public BroadSword() {
        //TODO: update displayChar of Broad Sword
        super("Broad Sword", '?', 30, "hits", 80);
    }

    @Override
    public int damage() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        if (randomNumber >= 0 && randomNumber <= 20) {
            return damage *= 2;
        }else{
            return damage;
        }
    }

}
