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

    public int getDefenceBonus() {
        return defenceBonus;
    }

    @Override
    public void use(Player player) {
        System.out.println("Nothing happened");
        System.out.println();
    }

    @Override
    public void showItemDetails() {
        super.showItemDetails();
        System.out.println("Defence bonus: " + this.defenceBonus);
        System.out.println();
    }
}
