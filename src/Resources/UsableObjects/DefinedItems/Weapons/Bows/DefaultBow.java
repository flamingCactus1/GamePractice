package Resources.UsableObjects.DefinedItems.Weapons.Bows;

import Resources.UsableObjects.Weapon;

import static Resources.WeaponClass.BOW;

public final class DefaultBow extends Weapon {

    public DefaultBow() {
        super("Standard bow", "This bow deals 5 damage and shoots wooden arrows",
                5, BOW );
    }
}
