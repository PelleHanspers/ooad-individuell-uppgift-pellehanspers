public class Consumable extends Item implements Usable {
    private int consumableValue;
    private StatType statType;

    public Consumable(String name, int weight, int goldValue, int consumableValue, StatType statType) {
        super(name, weight, goldValue);
        this.consumableValue = consumableValue;
        this.statType = statType;
    }
    public int getConsumableValue() {
        return consumableValue;
    }
    public StatType getStatType() {
        return statType;
    }

    @Override
    public void use(Player player) {
        System.out.println("using " + this.getName());
        if (this.getStatType() == StatType.HEALTH) {
            player.setHealthPoints(player.getHealthPoints() + getConsumableValue());
            System.out.println(player.getName() + " now has " + player.getHealthPoints() + " health points");
            player.removeItemFromInventory(this);
        }
        if (this.getStatType() == StatType.MANA) {
            player.setMana(player.getMana() + getConsumableValue());
            System.out.println(player.getName() + " now has " + player.getMana() + " mana");
            player.removeItemFromInventory(this);
        }
    }

    @Override
    public String toString() {
        return  "Name: " + getName() +
                "\nStrength: " + consumableValue +
                "\nPrice: " + getGoldValue();
    }
}
