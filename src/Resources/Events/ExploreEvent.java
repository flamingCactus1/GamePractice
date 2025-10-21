package Resources.Events;

import Resources.Characters.Player;
import Resources.UsableObjects.Armor;
import Resources.UsableObjects.DefinedItems.Armor.DefaultArmor;
import Resources.UsableObjects.DefinedItems.Armor.LegendaryArmor;
import Resources.UsableObjects.DefinedItems.Armor.MagicArmor;
import Resources.UsableObjects.DefinedItems.Potions.HealingPotion;
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
import Resources.UsableObjects.Item;
import Resources.UsableObjects.Weapon;

import java.util.Scanner;

import static Resources.UsefulFunctions.generateRandomInt;

public class ExploreEvent implements Event {
    private boolean decision;

    private void curseEvent(Player player, Item item, int amount, int probability) {
        int randomNumber = generateRandomInt(1, 100);
        if (randomNumber <= probability) {
            player.setMaxHealth(player.getMaxHealth() - amount);
            System.out.println("You have been cured by picking up the" + item.getName());
            System.out.println("Your max HP is reduced by " + amount);
            if (player.getHealth() > player.getMaxHealth()) {
                player.setHealth(player.getMaxHealth());
            }
        }
    }

    private Weapon generateAxe() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new OldLumberjacksAxe();
            case 3, 4, 5, 6 -> new CombatHammer();
            default -> new DefaultAxe();
        };
    }

    private Weapon generateBow() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new RoyalCrossbow();
            case 3, 4, 5, 6 -> new LongBow();
            default -> new DefaultBow();
        };
    }

    private Weapon generateDagger() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new EnhancedDefaultDagger();
            case 3, 4, 5, 6 -> new KitchenKnife();
            default -> new DefaultDagger();
        };
    }

    private Weapon generateWand() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new LightningWand();
            case 3, 4, 5, 6 -> new AIWand();
            default -> new DefaultWand();
        };
    }

    private int generateAmountOfHealingPotions() {
        return generateRandomInt(0, 2);
    }

    private Armor generateArmor() {
        int randomNumber = generateRandomInt(1, 10);
        return switch (randomNumber) {
            case 1, 2 -> new LegendaryArmor();
            case 3, 4, 5, 6 -> new MagicArmor();
            default -> new DefaultArmor();
        };
    }

    private void chestEvent(Player player) {
        int randomNumber = generateRandomInt(1, 4);
        Item objectInChest = switch (randomNumber) {
            case 1 -> generateAxe();
            case 2 -> generateBow();
            case 3 -> generateDagger();
            case 4 -> generateWand();
            default -> generateArmor();
        };
        int amountOfHealingPotions = generateAmountOfHealingPotions();
        System.out.println("You enter the room with the big chest in the middle of it");
        while (player.isAlive()) {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1. Explore the chest");
            System.out.println("2. Heal");
            System.out.println("3. Explore Inventory");
            System.out.println("4. Show your stats");
            System.out.println("5. Exit");
            System.out.print("->");
            String choice = input.nextLine();
            switch (choice.toLowerCase()) {
                case "1", "explore", "explore the chest", "explore chest", "chest" -> {
                    System.out.println("There is a " + objectInChest.getName() + " in the chest");
                    System.out.println("Would you like to collect it?");
                    System.out.println("Y/N ->");
                    choice = input.nextLine();
                    if (choice.toLowerCase().equals("y") || choice.toLowerCase().equals("yes")) {
                        player.pickUp(objectInChest);
                        curseEvent(player, objectInChest, generateRandomInt(5,20), 33);
                    }
                    if (amountOfHealingPotions > 0) {
                        System.out.println("There are " + amountOfHealingPotions + " healing potions in the chest as well");
                        System.out.println("Would you like to collect it?");
                        System.out.println("Y/N ->");
                        choice = input.nextLine();
                        if (choice.toLowerCase().equals("y") || choice.toLowerCase().equals("yes")) {
                            for (int i = 0; i < amountOfHealingPotions; i++) {
                                player.pickUp(new HealingPotion());
                            }
                        }
                    }
                    System.out.println("You returned to the entrance");
                }
                case "2", "heal" -> {
                    player.heal(30);
                }
                case "3", "explore inventory" -> {
                    player.exploreInventory();
                }
                case "4", "show your stats", "stats" -> {
                    player.showStats();
                }
                case "5", "exit" -> {
                    this.decision = true;
                }
                default -> {
                    System.out.println("Invalid choice. Try again.");
                }
            }
            System.out.println();
            if (this.decision) {
                player.setGoToMainMenu(true);
                break;
            }
        }
    }


    @Override
    public void execute(Player player) {
        chestEvent(player);
    }
}
