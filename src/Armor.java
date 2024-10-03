public class Armor extends Item implements Equippable {
    private int armorValue;
    DamageType defenseType;
    public Armor(String name, int weight, int goldValue, int armorValue, DamageType defenseType) {
        super(name, weight, goldValue);
        this.armorValue = armorValue;
        this.defenseType = defenseType;
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
    public void equip() {
        System.out.println("Equipping " + getName());
    }

    @Override
    public void unequip() {
        System.out.println("Unequipping " + getName());
    }
}
