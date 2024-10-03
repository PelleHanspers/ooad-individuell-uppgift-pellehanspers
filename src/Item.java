public class Item {
    private String name;
    private int weight;
    private int goldValue;

    public Item(String name, int weight, int goldValue) {
        this.name = name;
        this.weight = weight;
        this.goldValue = goldValue;
    }
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getGoldValue() {
        return goldValue;
    }



}
