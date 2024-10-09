public class Consumable extends Item implements Useable {
    private int consumableValue;

    public Consumable(String name, int weight, int goldValue, int consumableValue) {
        super(name, weight, goldValue);
        this.consumableValue = consumableValue;
    }

    @Override
    public void use(Player player) {
        System.out.println("using " + this.getName());
        if (this.getName().equals("HealthPotion")) {
            player.setHealthPoints(player.getHealthPoints() + consumableValue);
            System.out.println(player.getName() + " now has " + player.getHealthPoints() + " health points");
            player.removeItemFromInventory(this);
        }
        if (this.getName().equals("ManaPotion")) {
            player.setMana(player.getMana() + consumableValue);
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
