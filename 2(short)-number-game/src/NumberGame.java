import java.util.Random;
import java.util.Scanner;

/**
 * A a guessing game where the computer will generate a random number between 1-100,
 * and the user gets 10 guesses to find out what that number is.
 *
 * @author  Silver Lumi
 * @version 1.0
 */
public class NumberGame {
    private static final int NO_OF_GUESSES = 10;

    public static void main(String [] args) {
        Random randomNum = new Random();
        // create a random number between 1 and 100
        int randomNumber = 1 + randomNum.nextInt(100);

        // keep track if the game was lost or won
        boolean hasWon = false;

        System.out.println("I have randomly chosen a number between 1 and 100.");
        System.out.println("Try to guess it");

        Scanner scan = new Scanner(System.in);

        // let the user guess
        for (int i = NO_OF_GUESSES; i > 0; i--) {
            System.out.print("You have " + i + " guesses left. Your guess: ");

            // get input from user
            while(!scan.hasNextInt()) {
                System.out.print("Invalid input, try again: ");
                scan.next();
            }
            int guess = scan.nextInt();

            // compare the guess to the number and guide the user, if the answer
            // is correct, break out of the loop
            if (randomNumber < guess) {
                System.out.println("It's smaller than " + guess + ".");
            }
            else if (randomNumber > guess) {
                System.out.println("It's bigger than " + guess + ".");
            }
            else {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            System.out.println("CORRECT... YOU WIN!!!");
        }
        else {
            System.out.println("GAME OVER... YOU LOSE!!!");
            System.out.println("The number was : " + randomNumber);
        }
    }
}
