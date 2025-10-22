package Resources;

import Resources.Characters.Player;
import Resources.UsableObjects.DefinedItems.Potions.HealingPotion;
import Resources.UsableObjects.Item;

import java.util.ArrayList;

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

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                break;
            }
        }
    }

    public void showInventory() {
        items.forEach(n -> System.out.println(n.getName()));
        System.out.println();
    }

    public void showDetails(String name) {

        items.stream()
                .filter(n -> n.getName()
                        .equalsIgnoreCase(name))
                .findFirst().ifPresentOrElse(n -> n.showItemDetails(), () -> System.out.println("Item not found"));
        System.out.println();
    }

    public void useItem(Item  item, Player player) {
        if (items.contains(item)) {
            item.use(player);
            if (item instanceof HealingPotion) {;
                removeItem(item);
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
