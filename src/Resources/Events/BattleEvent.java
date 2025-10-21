package Resources.Events;

import Resources.Characters.Enemy;
import Resources.Characters.Player;
import Resources.Characters.PlayerClass;
import Resources.UsableObjects.DefinedItems.Potions.HealingPotion;

import java.util.Scanner;

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
            switch (choice) {
                case "1", "Attack", "attack", "ATTACK" -> {
                    player.attack(this.enemy);
                    actionPoints--;
                }
                case "2", "Heal", "heal", "HEAL" -> {
                    player.heal(30);
                }
            }

        }
    }

    @Override
    public void execute(Player player) {
        this.enemy = new Enemy();
        System.out.println(this.enemy.getName() + " the " + this.enemy.getEnemyTypeString() + " aggressively stares at you");
        System.out.println();
        while(enemy.isAlive() && player.isAlive()){

        }

    }
}
