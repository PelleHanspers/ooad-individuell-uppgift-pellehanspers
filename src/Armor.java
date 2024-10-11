import java.util.List;

public class Armor extends Item implements Equippable {
    private int armorValue;
    DamageType defenseType;
    List<EquipmentSlot> equippableOn;

    public Armor(String name, int weight, int goldValue, int armorValue, DamageType defenseType, List<EquipmentSlot> equippableOn) {
        super(name, weight, goldValue);
        this.armorValue = armorValue;
        this.defenseType = defenseType;
        this.equippableOn = equippableOn;
    }
    public List<EquipmentSlot> getEquippableOn() {
        return equippableOn;
    }
    public int getArmorValue() {
        return armorValue;
    }

    public DamageType getDefenseType() {
        return defenseType;
    }
    public void damageMitigation() {

    }
    public boolean equip(Player player, EquipmentSlot slot) {
        if (getEquippableOn().contains(slot)) {
            return player.equipItem(slot, this);
        } else {
            System.out.println("Cannot equip " + getName() + " in " + slot);
            return false;
        }
    }
    @Override
    public void unequip(Player player) {
        EquipmentSlot equippedSlot = null;
        for (EquipmentSlot slot : getEquippableOn()) {
            if (player.getEquippedItems().containsKey(slot) && player.getEquippedItems().get(slot) == this) {
                equippedSlot = slot;
                break;
            }
        }
        if (equippedSlot != null) {
            player.getEquippedItems().remove(equippedSlot, this);
            System.out.println("Unequipping " + getName() + " from " + equippedSlot);
        } else {
            System.out.println("Item " + getName() + " is not equipped.");
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
