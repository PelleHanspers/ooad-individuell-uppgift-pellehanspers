public class Main {
    public static void main(String[] args) {

        Game game = new Game(new PlayerMenu(), new ShopMenu());
        game.run();
    }
}