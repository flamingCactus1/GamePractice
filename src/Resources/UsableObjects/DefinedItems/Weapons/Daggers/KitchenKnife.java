package Resources.UsableObjects.DefinedItems.Weapons.Daggers;

import Resources.UsableObjects.Weapon;
import Resources.WeaponClass;

public final class KitchenKnife extends Weapon {

    public KitchenKnife(){
        super("Kitchen Knife",
                "This knife is good for both creatures and salami",
                10,
                WeaponClass.DAGGER);
    }
}
