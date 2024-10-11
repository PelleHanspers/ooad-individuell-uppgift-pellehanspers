import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Player player;
    PlayerMenu playerMenu;
    Shop firstShop;

    public Game(PlayerMenu playerMenu) {
        this.player = createPlayer();
        this.playerMenu = playerMenu;
        this.firstShop = new Shop();
        setShopInventory(firstShop);
    }

    public Player createPlayer() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        while (name.isEmpty()) {
            System.out.println("Please enter player name: ");
            name = sc.nextLine();
        }
        return new Player(name, 100, 100, 50);
    }

    public void setShopInventory(Shop shop) {
        Item i1 = new Weapon("Sword", 6, 8, 40, DamageType.PHYSICAL, Arrays.asList(EquipmentSlot.ARMR, EquipmentSlot.ARML ));
        Item i2 = new Armor("PlateArmor", 7, 15, 25, DamageType.MAGICAL, Arrays.asList(EquipmentSlot.TORSO ));
        Item i3 = new Consumable("HealthPotion", 2, 12, 25, StatType.HEALTH);
        Item i4 = new Consumable("ManaPotion", 2, 12, 35, StatType.MANA);
        Item i5 = new Armor("Shield", 5, 12, 30, DamageType.PHYSICAL, Arrays.asList(EquipmentSlot.ARMR, EquipmentSlot.ARML ));
        Item i6 = new Weapon("Bow", 4, 20, 15 , DamageType.MAGICAL, Arrays.asList(EquipmentSlot.ARMR, EquipmentSlot.ARML ));
        Item i7 = new Armor("Helmet", 4, 20, 15 , DamageType.PHYSICAL, Arrays.asList(EquipmentSlot.HEAD ));
        shop.getInventory().addItem(i1);
        shop.getInventory().addItem(i2);
        shop.getInventory().addItem(i3);
        shop.getInventory().addItem(i4);
        shop.getInventory().addItem(i5);
        shop.getInventory().addItem(i6);
        shop.getInventory().addItem(i7);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            choice = playerMenu.displayMenuAndGetInput(sc);
            playerMenu.handleMenuInput(choice, player, sc);

            if (choice == 4) {
                ShopMenu shopMenu = firstShop.getShopMenu();
                shopMenu.setShop(firstShop);
                int input;
                do {
                    input = shopMenu.displayMenuAndGetInput(sc);
                    shopMenu.handleMenuInput(input, player, sc);
                } while (input != 0);
            }
        }
    }
}
