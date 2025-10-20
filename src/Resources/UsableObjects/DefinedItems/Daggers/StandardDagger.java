package Resources.UsableObjects.DefinedItems.Daggers;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public class StandardDagger extends Weapon {

    public StandardDagger() {
        super("Standard dagger", "This dagger deals 5 damage and TBH is a bit rusty", 5, WeaponClass.DAGGER);
    }
}
