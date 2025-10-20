package Resources.UsableObjects;

import Resources.Characters.Player;

public class Armor extends Item{
    private int defenceBonus;

    public Armor(String name, String description, int defenceBonus) {
        super(name, description);
        this.defenceBonus = defenceBonus;
    }

    public Armor() {
        super();
        this.defenceBonus = 0;
    }

    @Override
    public void use(Player player) {
        System.out.println("Nothing happened");
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Defence bonus: " + this.defenceBonus);
    }
}
