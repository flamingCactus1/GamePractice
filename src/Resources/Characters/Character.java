package Resources.Characters;

abstract public class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int defence;



    public abstract void attack(Character target);

    public void takeDamage(int amount){
        this.health -= amount;
    }

    public boolean isAlive(){
        return this.health >= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void heal(int amount) {
        this.health = Math.min(this.health + amount, maxHealth);
    }
}
