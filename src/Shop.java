public class Shop {
    Inventory inventory;

    public Shop() {
        this.inventory = new Inventory();
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void buyItem(Player player, Item item) {
        if (player.getGold() >= item.getGoldValue()) {
            player.addItemToInventory(item);
            player.setGold(player.getGold() - item.getGoldValue());
            System.out.println("You successfully purchased " + item.getName());
        } else {
            System.out.println("You don't have enough gold to purchase " + item.getName());
        }
    }
    public void sellItem(Player player, Item item) {
        player.setGold(player.getGold() + item.getGoldValue());
        player.removeItemFromInventory(item);
        System.out.println("You successfully sold " + item.getName());
    }
}
