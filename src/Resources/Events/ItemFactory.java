package Resources.Events;

import Resources.UsableObjects.Armor;
import Resources.UsableObjects.DefinedItems.Armor.DefaultArmor;
import Resources.UsableObjects.DefinedItems.Armor.LegendaryArmor;
import Resources.UsableObjects.DefinedItems.Armor.MagicArmor;
import Resources.UsableObjects.DefinedItems.Weapons.Axes.CombatHammer;
import Resources.UsableObjects.DefinedItems.Weapons.Axes.DefaultAxe;
import Resources.UsableObjects.DefinedItems.Weapons.Axes.OldLumberjacksAxe;
import Resources.UsableObjects.DefinedItems.Weapons.Bows.DefaultBow;
import Resources.UsableObjects.DefinedItems.Weapons.Bows.LongBow;
import Resources.UsableObjects.DefinedItems.Weapons.Bows.RoyalCrossbow;
import Resources.UsableObjects.DefinedItems.Weapons.Daggers.DefaultDagger;
import Resources.UsableObjects.DefinedItems.Weapons.Daggers.EnhancedDefaultDagger;
import Resources.UsableObjects.DefinedItems.Weapons.Daggers.KitchenKnife;
import Resources.UsableObjects.DefinedItems.Weapons.Wands.AIWand;
import Resources.UsableObjects.DefinedItems.Weapons.Wands.DefaultWand;
import Resources.UsableObjects.DefinedItems.Weapons.Wands.LightningWand;
import Resources.UsableObjects.Weapon;

import static Resources.UsefulFunctions.generateRandomInt;

public class ItemFactory {

    public static Weapon generateAxe() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new OldLumberjacksAxe();
            case 3, 4, 5, 6 -> new CombatHammer();
            default -> new DefaultAxe();
        };
    }

    public static Weapon generateBow() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new RoyalCrossbow();
            case 3, 4, 5, 6 -> new LongBow();
            default -> new DefaultBow();
        };
    }

    public static Weapon generateDagger() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new EnhancedDefaultDagger();
            case 3, 4, 5, 6 -> new KitchenKnife();
            default -> new DefaultDagger();
        };
    }

    public static Weapon generateWand() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new LightningWand();
            case 3, 4, 5, 6 -> new AIWand();
            default -> new DefaultWand();
        };
    }

    public static Armor generateArmor() {
        int  randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber){
            case 1, 2 -> new LegendaryArmor();
            case 4, 5, 6 -> new MagicArmor();
            default ->  new DefaultArmor();
        };
    }

    public static int generateAmountOfHealingPotions() {
        return generateRandomInt(0, 2);
    }
}
