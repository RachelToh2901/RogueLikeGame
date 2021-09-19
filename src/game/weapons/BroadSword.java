package game.weapons;

import java.util.Random;

public class BroadSword extends MeleeWeapon {

    public BroadSword(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
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
