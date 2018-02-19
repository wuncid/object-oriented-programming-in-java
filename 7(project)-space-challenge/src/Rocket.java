/*
Create a class Rocket that implements the SpaceShip Interface and hence implements all the methods above.
launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend the
Rocket class they will override these methods to return true or false based on the actual probability of each type.
carry and canCarry should be implemented here and will not need to be overridden in the U1 and U2 classes
 */

/**
 * Models a rocket.
 */
public class Rocket implements SpaceShip {

    private final int rocketCost;
    private final int rocketWeight;
    private final int maxRocketWeight;
    private int currentRocketWeight;

    public Rocket(int rocketCost, int rocketWeight, int maxRocketWeight) {
        this.rocketCost = rocketCost;
        this.rocketWeight = rocketWeight;
        this.maxRocketWeight = maxRocketWeight;
        this.currentRocketWeight = rocketWeight;
    }

    /**
     * Gets the cost of the rocket.
     * @return the cost of the rocket in dollars
     */
    public int getRocketCost() {
        return rocketCost;
    }

    /**
     * Gets the weight of the rocket without the cargo (kerb weight).
     *
     * @return the weight of the rocket without the cargo in tonnes (metric)
     */
    public int getRocketWeight() {
        return rocketWeight;
    }

    /**
     * Gets the weight of the rocket together with the maximum weight of the cargo.
     *
     * @return the weight of the rocket with the maximum weight of the cargo in tonnes (metric)
     */
    public int getMaxRocketWeight() {
        return maxRocketWeight;
    }

    /**
     * Gets the current weight of the rocket with the cargo.
     *
     * @return the current weight of the rocket and the cargo in tonnes (metric)
     */
    public int getCurrentRocketWeight() {
        return currentRocketWeight;
    }

    /**
     * Adds the weight of the item to the rocket weight.
     *
     * @param weight the weight of the item in tonnes (imperial)
     */
    public void addToCurrentWeight(int weight) {
        this.currentRocketWeight += weight;
    }

    /**
     * Determines if the launch was successful
     *
     * @return true if the launch was successful, else false
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * Determines if the landing was successful
     *
     * @return true if the landing was successful, else false
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * Determines if there is room for the item on the rocket
     *
     * @param item the item to check
     * @return true if the item can be carried by the rocket, else false
     */
    public final boolean canCarry(Item item) {
        System.out.print("Rocket: " + this.getCurrentRocketWeight() + "/"
                + this.getMaxRocketWeight() + " t, Item: " + item.getWeight() + " t");
        if (this.getCurrentRocketWeight() + item.getWeight() > this.getMaxRocketWeight()) {
            System.out.print(", Rocket is full | ");
            return false;
        }
        else {
            System.out.print(", Add | ");
            return true;
        }
    }

    /**
     * Loads the item to the rocket
     *
     * @param item the item to load
     */
    public final void carry(Item item) {
        this.addToCurrentWeight(item.getWeight());
    }
}
