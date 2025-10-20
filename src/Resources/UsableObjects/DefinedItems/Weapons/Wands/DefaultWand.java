package Resources.UsableObjects.DefinedItems.Weapons.Wands;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class DefaultWand extends Weapon {
    public DefaultWand() {
        super("Standard wand", "This wand deals 10 damage and casts a simple fireball", 10, WeaponClass.WAND);
    }


}
