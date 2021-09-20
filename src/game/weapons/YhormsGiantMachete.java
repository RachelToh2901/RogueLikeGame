package game.weapons;

public class YhormsGiantMachete extends MeleeWeapon {

    public YhormsGiantMachete (String name, char displayChar, int damage, String verb, int hitRate) {
        //TODO: update displayChar
        super("Yhorm Giant Machete", displayChar, 95, verb, 60);
    }

    public void ActivateEmberForm (){
        hitRate *= 30/100;
    }


}
