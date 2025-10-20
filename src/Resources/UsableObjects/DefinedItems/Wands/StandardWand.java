package Resources.UsableObjects.DefinedItems.Wands;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class StandardWand extends Weapon {
    public StandardWand() {
        super("Standard wand", "This wand deals 10 damage and casts a simple fireball", 10, WeaponClass.WAND);
    }


}
