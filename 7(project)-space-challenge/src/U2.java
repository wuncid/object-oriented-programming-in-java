/*
Create classes U1 and U2 that extend the Rocket class and override the land and launch methods to calculate the corresponding
chance of exploding and return either true or false based on a random number using the probability equation for each.
 */

import java.util.Random;

/**
 * Models a rocket of type 2.
 */
public class U2 extends Rocket {

    /**
     * Constructor for the rocket of type 2.
     */
    public U2() {
        super(120,18,29);
    }

    @Override
    public boolean launch() {
        Random randomNum = new Random();
        double randomPercentage = 1 + 99 * randomNum.nextDouble();
        double launchFailProbability = 4 * (this.getCurrentRocketWeight() - this.getRocketWeight())/(1.0*(this.getMaxRocketWeight() - this.getRocketWeight()));

        return randomPercentage > launchFailProbability;
    }

    @Override
    public boolean land() {
        Random randomNum = new Random();
        double randomPercentage = 1 + 99 * randomNum.nextDouble();
        double landingFailProbability = 8 * (this.getCurrentRocketWeight() - this.getRocketWeight())/(1.0*(this.getMaxRocketWeight() - this.getRocketWeight()));

        return randomPercentage > landingFailProbability;
    }
}
