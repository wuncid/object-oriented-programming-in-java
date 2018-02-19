/*
Create a Simulation class that is responsible for reading item data and filling up the rockets.

The Simulation class should include these methods:

loadItems: this method loads all items from a text file and returns an ArrayList of Items:
Each line in the text file consists of the item name followed by = then its weigh in kg. For example:
habitat=100000
colony=50000
food=50000
loadItems should read the text file line by line and create an Item object for each and then add it
to an ArrayList of Items. The method should then return that ArrayList.

loadU1: this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and
filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets
that are fully loaded.

loadU2: this method also takes the ArrayList of Items and starts creating U2 rockets and filling them with
those items the same way as with U1 until all items are loaded. The method then returns the ArrayList of
those U2 rockets that are fully loaded.

runSimulation: this method takes an ArrayList of Rockets and calls launch and land methods for each of
the rockets in the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false)
it will have to send that rocket again. All while keeping track of the total budget required to send each
rocket safely to Mars. runSimulation then returns the total budget required to send all rockets (including
the crashed ones).
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Methods to simulate sending a colony to mars, simulation object keeps track of the total budget for the simulation.
 */
public class Simulation {
    private int totalBudget;

    /**
     * Constructor for the simulation object.
     */
    public Simulation() {
        totalBudget = 0;
    }

    /**
     * Gets the total budget for the simulation.
     *
     * @return the budget of the simulation
     */
    public int getTotalBudget() {
        return this.totalBudget;
    }

    /**
     * Gets the item list as a array list.
     *
     * @param filename the name of the .txt file with the list of the items
     *                 each line in the text file consists of the item name followed by = then its weigh in kg. For example:
     *                 habitat=100000
     *                 colony=50000
     *                 food=50000
     * @return array list of Item objects
     */
    public static ArrayList<Item> loadItems(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            ArrayList<Item> items = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int index = line.indexOf("="); // find the index of the "=" character in the line
                String name = line.substring(0, index); // name of the item is the substring from 0 to the index
                int weight = Integer.parseInt(line.substring(index + 1)); // weight of the item is the rest of the substring after that index
                Item item = new Item(name, weight / 1000); // create a new item with the name and the weight, convert weight to tonnes (metric)
                items.add(item); // add the item to the list
            }

            System.out.println("OK");
            return items;
        }
        catch (FileNotFoundException exception) {
            System.out.println("File not found");
            return null;
        }
    }

    /**
     * Loads the items to the rocket of type 1.
     *
     * @param items the array list of items to load
     * @return the array list of loaded rockets of type 1
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        Rocket rocket = new U1();
        System.out.print("Loading a new rocket:\n");
        ArrayList<Rocket> loadedRockets = new ArrayList<>();

        // go through the items list
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            // if there is room for the item in the rocket, then load the item
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            }
            // else add the loaded rocket to the loaded rockets list
            else {
                System.out.println("Rocket " + (loadedRockets.size() + 1) + " deployed.");
                // if the rocket is full and the item is not the last, add a rocket to the rockets list, get a new rocket and load the item
                if (i != items.size() - 1) {
                    loadedRockets.add(rocket);
                    rocket = new U1();
                    System.out.print("Loading a new rocket:\n");
                    if (rocket.canCarry(item)) {
                        rocket.carry(item);
                    }
                }
            }
        }
        loadedRockets.add(rocket); // add the last rocket (fully loaded or not) to the rocket list
        System.out.println("Rocket " + loadedRockets.size() + " deployed.");

        return loadedRockets;
    }

    /**
     * Loads the items to the rocket of type 2.
     *
     * @param items the array list of items to load
     * @return the array list of loaded rockets of type 2
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        Rocket rocket = new U2();
        System.out.print("Loading a new rocket:\n");
        ArrayList<Rocket> loadedRockets = new ArrayList<>();

        // go through the items list
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            // if there is room for the item in the rocket, then load the item
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            }
            // else add the loaded rocket to the loaded rockets list
            else {
                System.out.println("Rocket " + (loadedRockets.size() + 1) + " deployed.");
                // if the rocket is full and the item is not the last, add a rocket to the rockets list, get a new rocket and load the item
                if (i != items.size() - 1) {
                    loadedRockets.add(rocket);
                    rocket = new U2();
                    System.out.print("Loading a new rocket:\n");
                    if (rocket.canCarry(item)) {
                        rocket.carry(item);
                    }
                }
            }
        }
        loadedRockets.add(rocket); // add the last rocket (fully loaded or not) to the rocket list
        System.out.println("Rocket " + loadedRockets.size() + " deployed.");

        return loadedRockets;
    }

    /**
     * Runs the simulations of sending rockets for the phase.
     *
     * @param loadedRockets the array list loaded rockets
     */
    public void runSimulationPhase(ArrayList<Rocket> loadedRockets) {
        int budget = 0;

        // go through the list of loaded rockets
        for (int i = 0; i < loadedRockets.size(); i++) {

            Rocket rocket = loadedRockets.get(i);
            boolean safelyLanded = false;

            // send the rocket until it has safely landed, adding the cost of the rocket to the total budget each time the rocket was sent
            while (!safelyLanded) {
                budget += rocket.getRocketCost();
                System.out.println("Sending rocket " + (i + 1) + ". ");
                safelyLanded = rocket.launch() && rocket.land();
                if (!safelyLanded) {
                    System.out.println("Rocket crashed. Sending again.");
                }
            }
        }
        System.out.println();
        this.totalBudget += budget; // add the budget of the phase to the total budget
    }
}
