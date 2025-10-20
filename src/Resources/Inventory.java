package Resources;

import Resources.Characters.Player;
import Resources.UsableObjects.DefinedItems.Potions.HealingPotion;
import Resources.UsableObjects.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<Item>();

    public Inventory() {
        for (int i = 0; i <= 3; i++) {
            items.set(i, new HealingPotion());
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equals(itemName));
    }

    public void showInventory() {
        items.forEach(n -> System.out.println(n.getName()));
    }

    public void showDetails(String name) {
        try {
            items.stream().filter(n -> n.getName().equals(name)).forEach(Item::showDetails);
        } catch (Exception e) {
            System.out.println("No such item");
        }
    }

}
