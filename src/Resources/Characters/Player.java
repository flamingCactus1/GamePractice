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
        this.equipment = new Equipment(this.getPlayerClass());
        this.inventory = new Inventory();
        this.level = 1;
        this.experience = 0;
        this.experienceToNextLevel = 100;
        showStats();

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
                case "Mage", "MAGE", "mage" -> setCharacterStats(PlayerClass.MAGE, 0,0,80);
                case "Barbarian", "BARBARIAN", "barbarian" -> setCharacterStats(PlayerClass.BARBARIAN, 5,3,70);
                case "Archer", "ARCHER", "archer" -> setCharacterStats(PlayerClass.ARCHER, 2,2,100);
                case "Rogue", "ROGUE", "rogue" -> setCharacterStats(PlayerClass.ROGUE, 3,1,100);
                default -> {
                    System.out.println("Invalid input");
                    done = false;
                }
            }
            System.out.println();
        } while (!done);
    }

    private void setCharacterStats(PlayerClass playerClass, int attack, int defence, int maxHealth) {
        this.playerClass = playerClass;
        this.setAttack(attack);
        this.setDefence(defence);
        this.setMaxHealth(maxHealth);
        this.setHealth(maxHealth);
    }

    private void levelUp() {

        this.level++;
        this.experience = experience > experienceToNextLevel ? experience - experienceToNextLevel : 0;
        this.experienceToNextLevel += 10;
        this.setMaxHealth(this.getMaxHealth() + 10);
        this.setHealth(this.getMaxHealth());
        this.setAttack(this.getAttack() + 2);
        this.setDefence(this.getDefence() + 1);
        System.out.println("Congratulations! You are now level " + this.level);
        System.out.println("Your HP have been restored");
        System.out.println("New stats");
        System.out.println("Max health: " + this.getMaxHealth());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Defence: " + this.getDefence());
        System.out.println();
    }

    public void gainExperience(int amount) {
        this.experience += amount;
        System.out.println("Congratulations, you gained " + this.experience + "EXP");
        if (this.experience >= this.experienceToNextLevel) {
            levelUp();
        }
    }

    public void showStats() {
        System.out.println("Name: " + this.getName());
        System.out.println("Class: " + this.getPlayerClassString());
        System.out.println("HP: " + this.getHealth() + "/" + this.getMaxHealth());
        System.out.println("Defence: " + this.getDefence());
        System.out.println("Defence with bonus: " + (this.getDefence() + this.equipment.getTotalDefenseBonus()));
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Attack with bonus: " + (this.getAttack() + this.equipment.getTotalAttackBonus()));
        System.out.println("Experience: " + this.experience);
        System.out.println("Experience to the next level: " + this.experienceToNextLevel);
        System.out.println();
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    private String getPlayerClassString(){
        return switch (this.playerClass){
            case MAGE -> "Mage";
            case BARBARIAN -> "Barbarian";
            case ARCHER -> "Archer";
            case ROGUE -> "Rogue";
            default -> "No class";
        };
    }

    @Override
    public void heal(int amount) {
        if(this.inventory.getAmountOfHealingPotions()>0){
            super.heal(amount);
            this.inventory.removeItem("Healing Potion");
        }else{
            System.out.println("No healing potions found");
        }
    }

    @Override
    public void attack(Character target) {
        int currentAttack = this.getAttack() + this.equipment.getTotalAttackBonus();
        target.takeDamage(currentAttack);
        System.out.println(this.getName() + " attacks");
        System.out.println(target.getName() + " takes " + currentAttack + " damage");
        System.out.println();

    }

    @Override
    public void takeDamage(int amount) {
        super.takeDamage(amount - this.equipment.getTotalDefenseBonus());
    }

}
