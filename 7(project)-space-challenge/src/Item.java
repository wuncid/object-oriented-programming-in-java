/*
Create an Item class that includes a String name and an int weight that will represent an item to be carried by the rockets
 */

/**
 * Models an item with a name and a weight.
 */
public class Item {
    private String name;
    private int weight;

    /**
     * Constructor for objects of class Item.
     *
     * @param name the name of the item
     * @param weight the weight of the item in tonnes (metric)
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Gets the weight of this item
     *
     * @return the weight of the item
     */
    public int getWeight() {
        return weight;
    }
}
