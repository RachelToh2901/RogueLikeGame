package game.weapons;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import game.activeSkills.ChargeAction;
import game.activeSkills.WindSlashAction;

import java.util.Random;

public class StormRuler extends MeleeWeapon {

    public StormRuler (String name, char displayChar, int damage, String verb, int hitRate) {
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

    @Override
    public WeaponAction getActiveSkill(Actor target, String direction) {
        int chargeCount = ChargeAction.getNumOfCharge();
        if (chargeCount <3){
            return new ChargeAction(this);
        }else{
            WeaponAction windSlashAction = new WindSlashAction(this, target, direction);
            ChargeAction.resetNumOfCharge();
            return windSlashAction;
        }
    }
}
