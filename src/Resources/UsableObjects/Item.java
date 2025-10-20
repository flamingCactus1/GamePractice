package Resources.UsableObjects;

import Resources.Characters.Player;

abstract public class Item {
    private String name;
    private String description;

    public Item() {
        this.name = "";
        this.description = "";
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    abstract public void use(Player player);

    public void showDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Description: " + this.description);
    }
}
