package Resources.UsableObjects.DefinedItems.Weapons.Wands;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class LightningWand extends Weapon {
    public LightningWand() {
        super("Lightning Wand",
                "Shoots lightnings and has some charging socket, that no other wand have",
                30,
                WeaponClass.WAND);
    }
}
