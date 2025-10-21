package Resources.Characters;

import static Resources.UsefulFunctions.generateRandomInt;

public class Enemy extends Character {
    private EnemyType enemyType;
    private int experienceReward;

    public Enemy() {
        this.setName(nameRandomizer());
        this.enemyType = typeRandomizer();
        createEnemyStats(this.enemyType);
    }

    private String nameRandomizer() {
        int randomNumber = generateRandomInt(1, 4);
        return switch (randomNumber) {
            case 1 -> "Scarry Josh";
            case 2 -> "Clumsy David";
            case 3 -> "Mr. Robinson";
            case 4 -> "Experiment no.11";
            default -> "No name";
        };
    }

    private EnemyType typeRandomizer() {
        int randomNumber = generateRandomInt(1, 3);
        return switch (randomNumber) {
            case 2 -> EnemyType.ORC;
            case 3 -> EnemyType.SKELETON;
            default -> EnemyType.GOBLIN;
        };
    }

    public void createEnemyStats(EnemyType enemyType) {
        switch (enemyType) {
            case ORC -> generateEnemy(4,3,70,30);
            case SKELETON -> generateEnemy(12,0,30,15);
            case GOBLIN -> generateEnemy(8,1,50,25);
            default -> System.out.println("No enemy type found");
        }
    }

    private void generateEnemy(int attack, int defence, int maxHealth, int experienceReward) {
        this.setAttack(attack);
        this.setDefence(defence);
        this.setMaxHealth(maxHealth);
        this.setHealth(maxHealth);
        this.experienceReward = experienceReward;
    }


    public void showEnemyStats() {
        System.out.println("Name: " + this.getName());
        System.out.println("Type: " + this.getEnemyTypeString());
        System.out.println("Health: " + this.getHealth() + "/" + this.getMaxHealth());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Defence: " + this.getDefence());
        System.out.println();

    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public String getEnemyTypeString() {
        return switch (this.enemyType) {
            case ORC -> "ORC";
            case SKELETON -> "SKELETON";
            case GOBLIN -> "GOBLIN";
            default -> "No type";
        };
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.getName() + " attacks");
        System.out.println();
        target.takeDamage(this.getAttack());
    }
}
