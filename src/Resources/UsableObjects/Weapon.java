package Resources.UsableObjects;

import Resources.Characters.Player;
import Resources.WeaponClass;

public class Weapon extends Item {
    private int attackBonus;
    private WeaponClass weaponClass;

    public Weapon(String name, String description, int attackBonus, WeaponClass weaponClass) {
        super(name, description);
        this.attackBonus = attackBonus;
        this.weaponClass = weaponClass;
    }

    public Weapon() {
        this("undefined", "undefined", 1, WeaponClass.BOW);
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus < 10 ? 10 : attackBonus;
    }

    public WeaponClass getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(WeaponClass weaponClass) {
        this.weaponClass = weaponClass;
    }

    @Override
    public void use(Player player) {

    }
}
