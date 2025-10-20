package Resources.UsableObjects;

import Resources.Characters.Player;

enum WeaponClass {
    BOW,
    AXE,
    WAND,
    DAGGER
}

public class Weapon extends Item{
    private int attackBonus;
    private WeaponClass weaponClass;


    @Override
    public void use(Player player) {

    }
}
