package Resources.UsableObjects.DefinedItems.Weapons.Daggers;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class DefaultDagger extends Weapon {

    public DefaultDagger() {
        super("Standard dagger", "This dagger deals 5 damage and TBH is a bit rusty", 5, WeaponClass.DAGGER);
    }
}
