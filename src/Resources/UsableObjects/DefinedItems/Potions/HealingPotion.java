package Resources.UsableObjects.DefinedItems.Potions;

import Resources.Characters.Player;
import Resources.UsableObjects.Item;
import Resources.UsableObjects.Potion;

public final class HealingPotion extends Potion {
    private int healingAmount;

    public HealingPotion(String name, String description) {
        super(name, description);
        this.healingAmount = 30;
    }

    @Override
    public void use(Player player) {
        player.heal(healingAmount);
        System.out.println("Healing Potion has been successful");
        System.out.println("Your HP are " + player.getHealth());
    }

    public void stateDetails(){
        System.out.println("Heals 30 HP");
    }
}
