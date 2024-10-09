
public class Weapon extends Item implements Equippable {
    private int damageValue;
    DamageType damageType;
    EquipmentSlot equippableOn;

    public Weapon(String name, int weight, int goldValue, int damageValue, DamageType damageType, EquipmentSlot equippableOn) {
        super(name, weight, goldValue);
        this.damageValue = damageValue;
        this.damageType = damageType;
        this.equippableOn = equippableOn;
    }
    public DamageType getDamageType() {
        return damageType;
    }
    public EquipmentSlot getEquippableOn() {
        return equippableOn;
    }
    public void attack() {
        System.out.println("Attacking with " + this.getName());
    }
    @Override
    public void equip(Player player) {
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
