import java.util.Scanner;

public interface Menu {
        int displayMenuAndGetInput(Scanner sc);
        void handleMenuInput(int input, Player player, Scanner sc);
    }
