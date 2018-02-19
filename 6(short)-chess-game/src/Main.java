// Override the isValidMove method in the Queen class.
// First call the parent's isValidMove to check for the boundaries
// Add more code to check for the queen's specific move validity

/**
 * A chess game tester.
 */
public class Main {
    public static void main (String [] args) throws Exception {

        // create a new queen with an initial position
        Queen queen = new Queen();
        Position queenInitialPosition = new Position(0,5);
        queen.position = queenInitialPosition;

        // test if the move to the new position is possible (does not take into account cases
        // where the position is occupied), that is not part of the exercise
        Position testPosition = new Position(0,3);
        if (queen.isValidMove(testPosition)) {
            System.out.println("Yes, you can move there.");
        }
        else {
            System.out.println("No, that is not possible");
        }
    }
}
