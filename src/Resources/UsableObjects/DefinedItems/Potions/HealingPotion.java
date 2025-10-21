package Resources.UsableObjects.DefinedItems.Potions;

import Resources.Characters.Player;
import Resources.UsableObjects.Item;
import Resources.UsableObjects.Potion;

public final class HealingPotion extends Potion {
    private final int healingAmount;

    public HealingPotion() {
        super("Healing Potion", "This potion heals 30 HP");
        this.healingAmount = 30;
    }

    @Override
    public void use(Player player) {
        player.heal(healingAmount);
        System.out.println("Healing Potion is used");
        System.out.println("Your HP are " + player.getHealth());
    }

}
