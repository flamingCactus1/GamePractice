package Resources.UsableObjects.DefinedItems.Weapons.Axes;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class DefaultAxe extends Weapon {

    public DefaultAxe() {
        super("Standard axe", "This axe deals 15 damage and made out of of stone", 15, WeaponClass.AXE);
    }
}
