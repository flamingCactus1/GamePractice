package Resources.Events;

import Resources.Characters.Enemy;
import Resources.Characters.Player;
import Resources.Characters.PlayerClass;

import java.util.Scanner;

import static Resources.UsefulFunctions.generateRandomInt;

public class BattleEvent implements Event {
    private Enemy enemy;


    private void makeMove(Player player) {
        int actionPoints = player.getPlayerClass() == PlayerClass.ROGUE ? 2: 1;
        while (actionPoints > 0) {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Explore Inventory");
            System.out.println("4. Show your stats");
            System.out.println("5. Show enemy stats");
            System.out.println("6. Exit");
            System.out.print("->");
            String choice = input.nextLine();
            switch (choice.toLowerCase()) {
                case "1", "attack" -> {
                    player.attack(this.enemy);
                    actionPoints--;
                }
                case "2", "heal" -> {
                    player.heal(30);
                    actionPoints--;
                }
                case "3", "explore" -> {
                    player.exploreInventory();
                }
                case "4", "show your stats", "stats" -> {
                    player.showStats();
                }
                case "5", "show enemy stats", "enemy stats"{
                    this.enemy.showEnemyStats();
                }
                case "6", "exit" -> {
                    break;
                }
                default -> {
                    System.out.println("Invalid choice. Try again.");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void execute(Player player) {
        this.enemy = new Enemy();
        System.out.println(this.enemy.getName() + " the " + this.enemy.getEnemyTypeString() + " aggressively stares at you");
        System.out.println();
        while(enemy.isAlive() && player.isAlive()){
            makeMove(player);
            if(!this.enemy.isAlive()){
                player.gainExperience(this.enemy.getExperienceReward());
                System.out.println("Congratulations, you've won!");
                System.out.println();
                break;
            }
            int enemyChoice = generateRandomInt(1,8);
            switch (enemyChoice){
                case 1 -> this.enemy.heal(5);
                case 2 -> {
                    System.out.println("Enemy has attempted to attack");
                    System.out.println("Attack had no effect on you");
                }
                default -> this.enemy.attack(player);
            }
            if (!player.isAlive()){
                System.out.println("You've lost!");
                break;
            }
        }
    }
}
