package Resources.UsableObjects.DefinedItems.Weapons.Bows;

import Resources.UsableObjects.Weapon;

import static Resources.WeaponClass.BOW;

public class DefaultBow extends Weapon {

    public DefaultBow() {
        super("Default bow", "This bow deals 5 damage and shoots wooden arrows",
                5, BOW );
    }
}
