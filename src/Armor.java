import java.util.Map;

public class Armor extends Item implements Equippable {
    private int armorValue;
    DamageType defenseType;
    EquipmentSlot equippableOn;

    public Armor(String name, int weight, int goldValue, int armorValue, DamageType defenseType, EquipmentSlot equippableOn) {
        super(name, weight, goldValue);
        this.armorValue = armorValue;
        this.defenseType = defenseType;
        this.equippableOn = equippableOn;
    }
    public int getArmorValue() {
        return armorValue;
    }
    public DamageType getDefenseType() {
        return defenseType;
    }
    public void damageMitigation() {

    }
    @Override
    public void equip(Player player) {
/*
        for (Map.Entry<EquipmentSlot, Item> entry : player.getEquippedItems().entrySet()) {
            EquipmentSlot slot = entry.getKey();
            Item item = entry.getValue();
            System.out.println("Slot: " + slot + "\n" + item);
        }
*/
        if (player.getEquippedItems().containsKey(equippableOn)) {
            System.out.println("A " + player.getEquippedItems().get(equippableOn).getName() + " is already equipped in " + equippableOn);
            // Add logic to confirm or replace item
        } else {
            player.getEquippedItems().put(equippableOn, this);
            System.out.println("Equipped " + getName() + " in slot " + equippableOn);
        }
    }
    @Override
    public void unequip(Player player) {
        if (player.getEquippedItems().containsKey(equippableOn)) {
            player.getEquippedItems().remove(equippableOn, this);
            System.out.println("Unequipping " + getName());
        }
    }
    @Override
    public String toString() {
        return
                "Name: " + getName() +
                        "\nType: " + defenseType +
                        "\nWeight: " + getWeight() +
                        "\nPrice: " + getGoldValue() +
                        "\nDamage: " + armorValue +
                        "\nequippableOn: " + equippableOn
                ;
    }
}
