package Resources;

import Resources.Characters.Player;
import Resources.UsableObjects.DefinedItems.Potions.HealingPotion;
import Resources.UsableObjects.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();

    public Inventory() {
        for (int i = 0; i < 3; i++) {
            items.add(new HealingPotion());
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
        System.out.println();
    }

    public void showDetails(String name) {
        try {
            items.stream().filter(n -> n.getName().equals(name)).forEach(Item::showDetails);
        } catch (Exception e) {
            System.out.println("No such item");
        }
        System.out.println();
    }

    public void useItem(Item  item, Player player) {
        if (items.contains(item)) {
            item.use(player);
            if (item instanceof HealingPotion) {
                items.removeIf(n -> n.getName().equals(item.getName()));
            }
        }
    }

    public Item getItem(String itemName) {
        return items.stream().filter(n -> n.getName().equals(itemName)).findFirst().orElse(null);
    }

    public long getAmountOfHealingPotions() {
        return items.stream().filter(n -> n instanceof HealingPotion).count();
    }


    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(n -> n.getName().equals(itemName));
    }
}
