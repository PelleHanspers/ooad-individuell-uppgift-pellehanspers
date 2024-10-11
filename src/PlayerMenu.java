import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class PlayerMenu implements Menu {
    public PlayerMenu() {
    }

    @Override
    public int displayMenuAndGetInput(Scanner sc) {
        System.out.println("Player Menu:");
        System.out.println("1. view inventory");
        System.out.println("2. view player stats");
        System.out.println("3. manage equipment");
        System.out.println("4. visit shop");
        System.out.println("0. exit");

        int input = -1;
        try {
            input = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }
        return input;
    }
    @Override
    public void handleMenuInput(int input, Player player, Scanner sc) {
        switch (input) {
            case 1:
                if (player.getInventory().getItems().isEmpty()) {
                    System.out.println("Inventory is empty");
                } else {
                    System.out.println("Inventory:");
                    ArrayList<Item> items = player.getInventory().getItems();
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println((i + 1) + "." + items.get(i).getName());
                    }
                    System.out.println("Use item? (0 to exit)");
                    while (input != 0) {
                        try {
                            input = Integer.parseInt(sc.nextLine());
                            if (input > 0 && input <= items.size()) {
                                Item itemSelected = items.get(input - 1);
                                if (itemSelected instanceof Weapon || itemSelected instanceof Armor) {
                                    boolean equipped = false;
                                    while (!equipped) {
                                        System.out.println("Where do you want to equip" + itemSelected.getName() + "? (0 to exit)");
                                        System.out.println("(1) HEAD, (2) TORSO, (3) ARMR, (4) ARML, (5) LEGR, (6) LEGL");

                                        try {
                                            input = Integer.parseInt(sc.nextLine());
                                            if (input == 0) {
                                                System.out.println("Equip action cancelled.");
                                                break;
                                            }
                                            if (input > 0 && input <= EquipmentSlot.values().length) {
                                                EquipmentSlot slot = EquipmentSlot.values()[input - 1];
                                                Equippable equippableItem = (Equippable) itemSelected;
                                                equipped = equippableItem.equip(player, slot);
                                            } else {
                                                System.out.println("Please enter a valid slot number.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Please enter a valid number.");
                                        }
                                    }
                                    break;
                                } else if (itemSelected instanceof Consumable) {
                                    ((Usable) itemSelected).use(player);
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                        }
                    }
                }
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 2:
                System.out.println("Player stats:"
                        + "\nName: " + player.getName()
                        + "\nHP: " + player.getHealthPoints()
                        + "\nMana: " + player.getMana()
                        + "\nGold: " + player.getGold());
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 3:
                if (player.getEquippedItems().isEmpty()) {
                    System.out.println("No items equipped at the moment.");
                } else {
                    System.out.println("Equipped Items:");
                    System.out.println("---");
                    ArrayList<Item> equippedValues = new ArrayList<>(player.getEquippedItems().values());
                    int i = 0;
                    for (Map.Entry<EquipmentSlot, Item> entry : player.getEquippedItems().entrySet()) {
                        i++;
                        EquipmentSlot slot = entry.getKey();
                        Item item = entry.getValue();

                        System.out.println(i + ". \n" + item + "\nEquipped on: " + slot);
                        System.out.println("---");
                    }
                    System.out.println("Unequip item? (0 to exit)");
                    while (input != 0) {
                        try {
                            input = Integer.parseInt(sc.nextLine());
                            if (input > 0 && input <= equippedValues.size()) {
                                Item item = equippedValues.get(input - 1);
                                if (item instanceof Weapon) {
                                    ((Weapon) item).unequip(player);
                                    break;
                                } else if (item instanceof Armor) {
                                    ((Armor) item).unequip(player);
                                    break;
                                }
                            } else {
                                System.out.println("Returning to menu.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                        }
                    }
                }
                System.out.println(". . . press any key to continue . . .");
                sc.nextLine();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid number");
        }
    }
}