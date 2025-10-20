package Resources.UsableObjects.DefinedItems.Bows;

import Resources.UsableObjects.Weapon;

import static Resources.WeaponClass.BOW;

public class DefaultBow extends Weapon {
    private int distance;

    public DefaultBow() {
        super("Default bow", "This bow deals 5 damage and shoots wooden arrows",
                5, BOW );
        this.distance = 5;
    }
}
