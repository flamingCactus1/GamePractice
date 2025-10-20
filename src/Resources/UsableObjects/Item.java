package Resources.UsableObjects;

import Resources.Characters.Player;

abstract public class Item {
    protected String name;
    protected String description;

    abstract public void use(Player player);
}
