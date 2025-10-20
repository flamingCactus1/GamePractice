package Resources;

import Resources.UsableObjects.Armor;
import Resources.UsableObjects.Item;
import Resources.UsableObjects.Weapon;

public class Equipment {
    protected Item weapon;
    protected Item armor;

    public void equip(Item item) {
        if (item instanceof Weapon) {
            this.weapon = item;
        } else if (item instanceof Armor) {
            this.armor = item;
        }else {
            System.out.println("Cannot equip this item");
        }
    }
}
