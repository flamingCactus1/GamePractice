package Test;

import Resources.Inventory;
import Resources.UsableObjects.DefinedItems.Weapons.Daggers.DefaultDagger;

import static Resources.Events.ItemFactory.generateAxe;

public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new DefaultDagger());
        inventory.showDetails("standard dagger");
    }
}
