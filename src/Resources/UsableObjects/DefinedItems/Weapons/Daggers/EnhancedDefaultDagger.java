package Resources.UsableObjects.DefinedItems.Weapons.Daggers;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class EnhancedDefaultDagger extends Weapon {
    public EnhancedDefaultDagger(){
        super("Oddly familiar looking dagger",
                "This dagger belonged to one of your previous iterations and was enhanced with your death",
                17,
                WeaponClass.DAGGER);
    }
}
