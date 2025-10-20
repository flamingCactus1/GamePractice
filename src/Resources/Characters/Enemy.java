package Resources.Characters;

public class Enemy extends Character {
    private EnemyType enemyType;
    private int experienceReward;

    public Enemy() {
        this.setName(nameRandomizer());
        this.enemyType = typeRandomizer();
        createEnemyStats(this.enemyType);
    }

    private String nameRandomizer() {
        int randomNumber = (int) (Math.random() * 3 + 1);
        return switch (randomNumber) {
            case 1 -> "Scarry Josh";
            case 2 -> "Clumsy David";
            case 3 -> "Mr. Robinson";
            case 4 -> "Experiment no.11";
            default -> "No name";
        };
    }

    private EnemyType typeRandomizer() {
        int randomNumber = (int) (Math.random() * 2 + 1);
        return switch (randomNumber) {
            case 2 -> EnemyType.ORC;
            case 3 -> EnemyType.SKELETON;
            default -> EnemyType.GOBLIN;
        };
    }

    public void createEnemyStats(EnemyType enemyType){
        switch (enemyType){
            case ORC -> createOrc();
            case SKELETON -> createSkeleton();
            case GOBLIN -> createGoblin();
            default -> System.out.println("No enemy type found");
        }
    }

    public void createSkeleton(){
        this.setAttack(6);
        this.setDefence(0);
        this.setMaxHealth(30);
        this.setHealth(30);
        this.experienceReward = 15;
    }

    public void createGoblin(){
        this.setAttack(4);
        this.setDefence(1);
        this.setMaxHealth(50);
        this.setHealth(50);
        this.experienceReward = 25;
    }

    public void createOrc(){
        this.setAttack(2);
        this.setDefence(3);
        this.setMaxHealth(70);
        this.setHealth(70);
        this.experienceReward = 30;
    }

    public void showEnemyStats(){
        System.out.println("Name: " + this.getName());
        System.out.println("Type: " + this.getEnemyTypeString());
        System.out.println("Health: " + this.getHealth() + "/" + this.getMaxHealth());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Defence: " + this.getDefence());

    }

    public int getExperienceReward() {
        return experienceReward;
    }

    private String getEnemyTypeString(){
        return switch (this.enemyType){
            case ORC -> "ORC";
            case SKELETON -> "SKELETON";
            case GOBLIN -> "GOBLIN";
            default -> "No type";
        };
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(this.getAttack());
    }
}
