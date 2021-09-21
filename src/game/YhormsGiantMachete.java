package game;

public class YhormsGiantMachete extends MeleeWeapon{

    /**
     * Constructor.
     *
     */
    public YhormsGiantMachete() {
        super("Yhorm's Giant Machete", 'M', 95, "burns", 60);
    }

    public void rageMode () {
        hitRate += 30;
    }
}
