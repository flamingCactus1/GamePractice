package Resources.UsableObjects;

import Resources.Characters.Player;

public class Potion extends Item {

    public Potion(String name, String description) {
        super(name, description);
    }

    public Potion() {
        super();
    }

    @Override
    public void use(Player player) {
        System.out.println("Nothing happened");
        System.out.println();
    }
}
