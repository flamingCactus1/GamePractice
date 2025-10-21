package Resources.UsableObjects.DefinedItems.Weapons.Wands;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class AIWand extends Weapon {

    public AIWand() {
        super("AI Wand",
                "This AI wand will automatically choose a spell, that will PROBABLY be correct in this particular situation",
                18,
                WeaponClass.WAND);
    }
}
