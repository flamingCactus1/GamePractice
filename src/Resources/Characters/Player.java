package Resources.Characters;

import Resources.Equipment;
import Resources.Inventory;
import Resources.UsableObjects.DefinedItems.Potions.HealingPotion;
import Resources.UsableObjects.Item;
import Resources.UsableObjects.Potion;

import java.util.Scanner;

public class Player extends Character {
    private PlayerClass playerClass;
    private Inventory inventory;
    private Equipment equipment;
    private int level;
    private int experience;
    private int experienceToNextLevel;

    public Player() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        System.out.print("->");
        this.setName(sc.nextLine());
        setPlayerClass();

    }

    private void setPlayerClass() {
        boolean done = true;
        do {
            String response = "";
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose your class:");
            System.out.println("1. MAGE");
            System.out.println("2. BARBARIAN");
            System.out.println("3. ARCHER");
            System.out.println("4. ROGUE");
            System.out.print("->");
            response = sc.nextLine();
            switch (response) {
                case "Mage", "MAGE", "mage" -> this.playerClass = PlayerClass.MAGE;
                case "Barbarian", "BARBARIAN", "barbarian" -> this.playerClass = PlayerClass.BARBARIAN;
                case "Archer", "ARCHER", "archer" -> this.playerClass = PlayerClass.ARCHER;
                case "Rogue", "ROGUE", "rogue" -> this.playerClass = PlayerClass.ROGUE;
                default -> {
                    System.out.println("Invalid input");
                    done = false;
                }
            }
        } while (!done);
    }

    public void levelUp() {
        if (experienceToNextLevel == experience) {
            this.level++;
            this.experienceToNextLevel += 10;
            this.experience = 0;

        }
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void useItem(Item item) {
        if(item instanceof Potion){
            item.use(this);
        }else {
            System.out.println("Nothing happened");
        }
    }

    @Override
    public void attack(Character target) {

    }
}
