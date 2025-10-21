package Resources.UsableObjects.DefinedItems.Weapons.Axes;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class CombatHammer extends Weapon {

    public CombatHammer() {
        super("Combat Hammer",
                "Yeah, this is not exactly an axe, but since when do you care?",
                20,
                WeaponClass.AXE);
    }
}
