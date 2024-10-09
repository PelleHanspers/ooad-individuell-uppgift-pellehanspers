import java.util.List;
import java.util.Scanner;

public class ShopMenu implements Menu {
    private Shop currentShop;

    public ShopMenu() {
    }

    public void setShop(Shop shop) {
        this.currentShop = shop;
    }
    public int displayMenuAndGetInput(Scanner sc) {
        System.out.println("Shop Menu:");
        System.out.println("1. view all inventory");
        System.out.println("2. view all weapons");
        System.out.println("3. view all armor");
        System.out.println("4. view physical items");
        System.out.println("5. view magic items");
        System.out.println("6. view Consumables");
        System.out.println("7. Buy item");
        System.out.println("8. Sell item");
        System.out.println("0. Exit");

        int input = -1;
        try {
            input = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
        return input;
    }

    public void handleMenuInput(int input, Player player, Scanner sc) {
        switch (input) {
            case 1:
                System.out.println("All items in shop:");
                System.out.println("---");
                currentShop.getInventory().getItems().forEach(item -> System.out.println(item.getName()));
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 2:
                System.out.println("All weapons in shop:");
                System.out.println("---");
                for (Item item : currentShop.getInventory().getItems()) {
                    if (item instanceof Weapon) {
                        System.out.println(item);
                    }
                }
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 3:
                System.out.println("All armor in shop:");
                System.out.println("---");
                for (Item item : currentShop.getInventory().getItems()) {
                    if (item instanceof Armor) {
                        System.out.println(item);
                        System.out.println("---");
                    }
                }
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 4:
                System.out.println("Physical items:");
                System.out.println("---");
                for (Item item : currentShop.getInventory().getItems()) {
                    if (item instanceof Weapon && ((Weapon) item).getDamageType() == DamageType.PHYSICAL) {
                        System.out.println(item);
                        System.out.println("---");
                    } else if (item instanceof Armor && ((Armor) item).getDefenseType() == DamageType.PHYSICAL) {
                        System.out.println(item);
                        System.out.println("---");
                    }
                }
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 5:
                System.out.println("Magic Items:");
                System.out.println("---");
                for (Item item : currentShop.getInventory().getItems()) {
                    if (item instanceof Weapon && ((Weapon) item).getDamageType() == DamageType.MAGICAL) {
                        System.out.println(item);
                        System.out.println("---");
                    } else if (item instanceof Armor && ((Armor) item).getDefenseType() == DamageType.MAGICAL) {
                        System.out.println(item);
                        System.out.println("---");
                    }
                }
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 6:
                System.out.println("Consumables:");
                System.out.println("---");
                for (Item item : currentShop.getInventory().getItems()) {
                    if (item instanceof Consumable) {
                        System.out.println(item);
                        System.out.println("---");
                    }
                }
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 7:
                System.out.println("Choose item to buy:");
                List<Item> items = currentShop.getInventory().getItems();
                for (int i = 0; i < items.size(); i++) {
                    System.out.println((i + 1) + "." + items.get(i).getName() + " - " + items.get(i).getGoldValue() + " gold");
                }
                System.out.println("enter number for item to buy:");
                input = sc.nextInt();
                sc.nextLine();

                if (input > 0 && input <= items.size()) {
                    Item itemSelected = items.get(input -1);
                    System.out.println("You selected " + itemSelected.getName());
                    System.out.println("Confirm purchase (y/n):");
                    String response = sc.nextLine();
                    if (response.equals("y")) {
                        currentShop.buyItem(player, itemSelected);
                        System.out.println(". . . press any key to continue . . .");
                        sc.nextLine();
                    } else {
                        System.out.println("Purchase cancelled");
                    }
                } else {
                    System.out.println("Please enter a valid number");
                }
                break;
            case 8:
                System.out.println("Items to sell:");
                int i = 0;
                for (Item item : player.inventory.getItems()) {
                    System.out.println((i + 1) + ". " + item.getName() + " - " + item.getGoldValue() + " gold");
                }
                System.out.println("enter number for item to sell:");
                input = sc.nextInt();
                sc.nextLine();
                if (input > 0 && input <= player.inventory.getItems().size()) {
                    Item itemSelected = player.inventory.getItems().get(input - 1);
                    System.out.println("You selected " + itemSelected.getName());
                    System.out.println("Do you want to sell this item? (y/n):");
                    String response = sc.nextLine();
                    if (response.equals("y")) {
                        currentShop.sellItem(player, itemSelected);
                    } else {
                        System.out.println("Returning to menu");
                        break;
                    }
                } else {
                    System.out.println("Please enter a valid number");
                }
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 0:
                System.out.println("Exiting the shop.");
                break;
            default:
                System.out.println("Please enter a valid number");
            }
        }
    }

