import java.util.HashMap;
import java.util.Map;


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
    public boolean equipItem(EquipmentSlot slot, Item item) {
        if (getEquippedItems().containsKey(slot)) {
            System.out.println("Slot " + slot + " is already occupied by " + getEquippedItems().get(slot).getName());
            return false;
        }
        for (Map.Entry<EquipmentSlot, Item> entry : getEquippedItems().entrySet()) {
            if (entry.getValue().equals(item)) {
                System.out.println(item.getName() + " is already equipped in " + entry.getKey());
                return false;
            }
        }
        getEquippedItems().put(slot, item);
        System.out.println(item.getName() + " equipped in slot " + slot);
        return true;
    }
    public void addItemToInventory(Item item) {
        getInventory().addItem(item);
    }
    public void removeItemFromInventory(Item item) {
        getInventory().removeItem(item);
    }
}

