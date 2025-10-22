package Resources.Events;

import Resources.Characters.Player;
import Resources.UsableObjects.DefinedItems.Potions.HealingPotion;
import Resources.UsableObjects.Item;

import java.util.Scanner;

import static Resources.Events.ItemFactory.*;
import static Resources.UsefulFunctions.generateRandomInt;

public class ExploreEvent implements Event {
    private boolean decision;

    private void curseEvent(Player player, Item item, int amount, int probability) {
        int randomNumber = generateRandomInt(1, 100);
        if (randomNumber <= probability) {
            player.setMaxHealth(player.getMaxHealth() - amount);
            System.out.println("You have been cured by picking up the " + item.getName());
            System.out.println("Your max HP is reduced by " + amount);
            if (player.getHealth() > player.getMaxHealth()) {
                player.setHealth(player.getMaxHealth());
            }
        }
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
        boolean isExplored = false;
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
                    if (isExplored && amountOfHealingPotions == 0) {
                        System.out.println("You have already explored the chest");
                        System.out.println("There is nothing left for you inside the chest");
                    } else if (!isExplored) {
                        System.out.println("There is a " + objectInChest.getName() + " in the chest");
                        System.out.println("Would you like to collect it?");
                        System.out.print("Y/N ->");
                        choice = input.nextLine();
                        if (choice.toLowerCase().equals("y") || choice.toLowerCase().equals("yes")) {
                            player.pickUp(objectInChest);
                            curseEvent(player, objectInChest, generateRandomInt(5, 20), 33);
                            isExplored = true;
                        }
                    }
                    if (amountOfHealingPotions > 0) {
                        System.out.println("There are " + amountOfHealingPotions + " healing potions in the chest");
                        System.out.println("Would you like to collect it?");
                        System.out.print("Y/N ->");
                        choice = input.nextLine();
                        if (choice.toLowerCase().equals("y") || choice.toLowerCase().equals("yes")) {
                            for (int i = 0; i < amountOfHealingPotions; i++) {
                                player.pickUp(new HealingPotion());
                            }
                            amountOfHealingPotions = 0;
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
