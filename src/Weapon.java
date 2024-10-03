
public class Weapon extends Item implements Equippable{
    private int damage;
    DamageType damageType;

    public Weapon(String name, int weight, int goldValue, int damage, DamageType damageType) {
        super(name, weight, goldValue);
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
