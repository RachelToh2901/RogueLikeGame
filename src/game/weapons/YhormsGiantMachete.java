package game.weapons;

public class YhormsGiantMachete extends MeleeWeapon {

    public YhormsGiantMachete (String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    public void ActivateEmberForm (){
        hitRate *= 30/100;
    }


}
