package Resources;

import Resources.Characters.Player;
import Resources.Characters.PlayerClass;
import Resources.UsableObjects.Armor;
import Resources.UsableObjects.DefinedItems.Armor.DefaultArmor;
import Resources.UsableObjects.DefinedItems.Weapons.Axes.DefaultAxe;
import Resources.UsableObjects.DefinedItems.Weapons.Bows.DefaultBow;
import Resources.UsableObjects.DefinedItems.Weapons.Daggers.DefaultDagger;
import Resources.UsableObjects.DefinedItems.Weapons.Wands.DefaultWand;
import Resources.UsableObjects.Item;
import Resources.UsableObjects.Weapon;

public class Equipment {
    protected Weapon weapon;
    protected Armor armor;

    public Equipment() {
    }

    public Equipment(PlayerClass playerClass) {
        switch (playerClass) {
            case ARCHER -> equipStandardForArcher();
            case MAGE ->  equipStandardForMage();
            case ROGUE ->  equipStandardForRogue();
            case BARBARIAN -> equipStandardForBarbarian();
            default -> {
                System.out.println("No class found");
                System.out.println();
            }
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void equip(Item item, Player player) {
        if (item instanceof Weapon) {
            equipWeapon(player, (Weapon) item);
        } else if (item instanceof Armor) {
            this.armor = (Armor) item;
        } else {
            System.out.println("Cannot equip this item");
            System.out.println();
        }
    }

    public void equipStandardForMage() {
        this.armor = new DefaultArmor();
        this.weapon = new DefaultWand();
    }

    public void equipStandardForArcher() {
        this.armor = new DefaultArmor();
        this.weapon = new DefaultBow();
    }

    public void equipStandardForBarbarian() {
        this.armor = new DefaultArmor();
        this.weapon = new DefaultAxe();
    }

    public void equipStandardForRogue() {
        this.armor = new DefaultArmor();
        this.weapon = new DefaultDagger();
    }

    private void equipWeapon(Player player, Weapon weapon) {
        if ((weapon.getWeaponClass() == WeaponClass.BOW) && (player.getPlayerClass() != PlayerClass.ARCHER)) {
            System.out.println("You can not equip bows");
            System.out.println();
        } else {
            this.weapon = weapon;
            System.out.println(player.getName() + " equipped" + weapon.getName() + "as a weapon");
            System.out.println();
        }
        if ((weapon.getWeaponClass() == WeaponClass.WAND) && (player.getPlayerClass() != PlayerClass.MAGE)) {
            System.out.println("You can not equip wands");
            System.out.println();
        } else {
            this.weapon = weapon;
            System.out.println(player.getName() + " equipped" + weapon.getName() + "as a weapon");
            System.out.println();
        }
        if ((weapon.getWeaponClass() == WeaponClass.AXE) && (player.getPlayerClass() != PlayerClass.BARBARIAN)) {
            System.out.println("You can not equip axes");
            System.out.println();
        } else {
            this.weapon = weapon;
            System.out.println(player.getName() + " equipped" + weapon.getName() + "as a weapon");
            System.out.println();
        }
        if ((weapon.getWeaponClass() == WeaponClass.DAGGER) && (player.getPlayerClass() != PlayerClass.ROGUE)) {
            System.out.println("You can not equip daggers");
            System.out.println();
        }else {
            this.weapon = weapon;
            System.out.println(player.getName() + " equipped" + weapon.getName() + "as a weapon");
            System.out.println();
        }
    }

    public int getTotalAttackBonus(){
        return this.weapon.getAttackBonus();
    }

    public int getTotalDefenseBonus(){
        return this.armor.getDefenceBonus();
    }
}
