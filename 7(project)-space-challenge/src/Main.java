/*
Create a Main class with the main method and start running the simulation:
Create a Simulation object
Load Items for Phase-1 and Phase-2
Load a fleet of U1 rockets for Phase-1 and then for Phase-2
Run the simulation using the fleet of U1 rockets and display the total budget required.
Repeat the same for U2 rockets and display the total budget for that.
 */

import java.util.ArrayList;

/**
 * Simulations to compare which rocket is cheaper to use to start a colony on Mars.
 *
 * @author  Silver Lumi
 * @version 1.0
 */
public class Main {
    public static void main(String [] args) {

        String phase1 = "phase-1.txt";
        String phase2 = "phase-2.txt";

        System.out.println("\nLOAD THE LIST OF ITEMS\n");
        System.out.print("Phase 1: ");
        ArrayList<Item> itemsP1 = Simulation.loadItems(phase1); // load items for phase 1

        System.out.print("Phase 2: ");
        ArrayList<Item> itemsP2 = Simulation.loadItems(phase2); // load items for phase 2

        if (itemsP1 == null || itemsP2 == null) {
            System.out.println("Simulations failed. Make sure the item list files exist and are named correctly.\n");
            System.out.println("--------------------------------------------------------------------------------");
        }
        else {
            // the first simulation with U1 rockets
            Simulation sim1 = new Simulation(); // create a new simulation object for the first simulation

            System.out.println("\nSIMULATION 1\n");

            System.out.print("Phase 1:\n");
            sim1.runSimulationPhase(sim1.loadU1(itemsP1));

            System.out.print("Phase 2:\n");
            sim1.runSimulationPhase(sim1.loadU1(itemsP2));

            System.out.println("The budget for rocket U1 is " + sim1.getTotalBudget() + " million $.\n"); // display the budget
            System.out.println("--------------------------------------------------------------------");

            // the second simulation with U2 rockets
            Simulation sim2 = new Simulation(); // create a new simulation object for the first simulation

            System.out.println("\nSIMULATION 2\n");

            System.out.print("Phase 1:\n");
            sim2.runSimulationPhase(sim2.loadU2(itemsP1));

            System.out.print("Phase 2:\n");
            sim2.runSimulationPhase(sim2.loadU2(itemsP2));

            System.out.println("The budget for rocket U2 is " + sim2.getTotalBudget() + " million $.\n"); // display the budget
            System.out.println("--------------------------------------------------------------------\n");
        }
    }
}
