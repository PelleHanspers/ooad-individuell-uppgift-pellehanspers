import java.util.List;

public class Weapon extends Item implements Equippable {
    private int damageValue;
    DamageType damageType;
    List<EquipmentSlot> equippableOn;

    public Weapon(String name, int weight, int goldValue, int damageValue, DamageType damageType, List<EquipmentSlot> equippableOn) {
        super(name, weight, goldValue);
        this.damageValue = damageValue;
        this.damageType = damageType;
        this.equippableOn = equippableOn;
    }
    public DamageType getDamageType() {
        return damageType;
    }
    public List<EquipmentSlot> getEquippableOn() {
        return equippableOn;
    }
    public void attack() {
        System.out.println("Attacking with " + this.getName());
    }
    @Override
    public boolean equip(Player player, EquipmentSlot slot) {
        if (this.getEquippableOn().contains(slot)) {
            return player.equipItem(slot, this);
        } else {
            System.out.println("Cannot equip " + getName() + " in " + slot);
            return false;
        }
    }
    @Override
    public void unequip(Player player) {
        EquipmentSlot equippedSlot = null;
        for (EquipmentSlot slot : this.getEquippableOn()) {
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
                "\nType: " + damageType +
                "\nWeight: " + getWeight() +
                "\nPrice: " + getGoldValue() +
                "\nDamage: " + damageValue +
                "\nequippableOn: " + equippableOn
                ;
    }

    public String toBasicString() {
        return
                "Name: " + getName() +
                "\nType: " + damageType +
                "\nDamage: " + damageValue
                ;
    }
}
