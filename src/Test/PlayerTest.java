package Test;

import Resources.Characters.Player;
import Resources.UsableObjects.DefinedItems.Weapons.Daggers.DefaultDagger;

public class PlayerTest {
    public static void main(String[] args) {
        Player player = new Player();
        player.pickUp(new DefaultDagger());
        player.exploreInventory();
    }
}
