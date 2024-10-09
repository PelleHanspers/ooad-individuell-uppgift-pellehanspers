import java.util.HashMap;

public class Player {
    private String name;
    private int healthPoints;
    private int mana;
    private int gold;
    Inventory inventory;
    private HashMap<EquipmentSlot, Item> equippedItems;

    public Player(String name, int healthPoints, int mana, int gold) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.mana = mana;
        this.gold = gold;
        this.inventory = new Inventory();
        this.equippedItems = new HashMap<>();
    }
    public String getName() {
        return name;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public HashMap<EquipmentSlot, Item> getEquippedItems() {
        return equippedItems;
    }
    public void addItemToInventory(Item item) {
        inventory.addItem(item);
    }
    public void removeItemFromInventory(Item item) {
        inventory.removeItem(item);
    }
}

