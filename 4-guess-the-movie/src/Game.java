import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A guessing game (hangman) where the computer will choose a random movie for the user to guess,
 * and the user gets 6 guesses of which letters the name contains to find out what that movie is.
 *
 * @author  Silver Lumi
 * @version 1.0
 */
public class Game {
    private static final int NO_OF_WRONG_GUESSES = 5;
    private ArrayList<String> movieList;
    private String chosenMovie;
    private String [] chosenMovieHidden;
    private int nrOfLetters;
    private int correctLetterCount;
    private boolean canStart;

    /**
     * Constructor for a new game. Takes in the name of the .txt file that contains the list of
     * the movies out of which the computer will choose a random movie from. Each movie name has
     * to be on a new line in the list.
     *
     * @param filename the name of the text file of the movie list
     */
    public Game(String filename) {

        try {
            movieList = importMovieList(filename);
            chosenMovie = chooseMovie();
            canStart = true;
        }
        catch (FileNotFoundException exception){
            System.out.println("File not found, change the file name and try again");
            canStart = false;
        }
    }

    /**
     * Loads the text file and scans the movie names to an array list of Strings.
     *
     * @param filename the name of the text file of the movie list
     * @return the array list of movie names
     */
    private ArrayList<String> importMovieList(String filename) throws FileNotFoundException {
        File movies = new File(filename);
        Scanner scanner = new Scanner(movies);

        ArrayList<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String movieName = scanner.nextLine();
            if (! movieName.isEmpty()) {
                list.add(movieName);
            }
        }
        return list;
    }

    /**
     * Generates a number from 0 to the size of the movie list. Gets the name of the movie with
     * his index from the movie array list.
     *
     * @return the array list of movie names
     */
    private String chooseMovie() {
        Random randomNum = new Random();
        int randomMovie = randomNum.nextInt(movieList.size());

        return movieList.get(randomMovie);
    }

    /**
     * Plays the game if the movie list was successfully loaded.
     */
    public void playGame() {
        if (canStart) {

            setHiddenName();
            printName();

            int wrongLetterCount = 0;
            String wrongLetterList = ""; // saves the letters that the user has already guessed to display them to the user

            Scanner input = new Scanner(System.in);
            boolean gameWon = false; // keeps track if the game was won or lost
            boolean letterWasCorrect;

            // ask for letters until the game is won or the maximum number of wrong guesses is reached
            while (wrongLetterCount < NO_OF_WRONG_GUESSES && !gameWon) {
                System.out.println();
                System.out.println("You have guessed (" + wrongLetterCount + "/" + NO_OF_WRONG_GUESSES + ") wrong letters: " + wrongLetterList);
                System.out.print("Guess a letter: ");

                // get the letter from the user
                String letter = "";
                while ((letter = input.next()).length() != 1) {
                    System.out.print("Enter just one character please: ");
                }

                // checks if the letter exists in the movie name, if it does then replaces all the "-" in the hidden name with that letter
                letterWasCorrect = false;
                for (int i = 0; i < nrOfLetters; i++) {
                    if (chosenMovie.substring(i, i + 1).equals(letter)) {
                        letterWasCorrect = true;
                        // if letter not already in the correct letter list, then increase the correct letter count
                        if (!chosenMovieHidden[i].equals(letter) ) {
                            correctLetterCount++;
                            chosenMovieHidden[i] = letter;
                        }
                    }
                }

                // adds incorrect letters to the wrong letter list and increases the wrong letter count
                if (!letterWasCorrect) {
                    if (wrongLetterCount == 0) {
                        wrongLetterList += letter;
                    } else {
                        wrongLetterList += ", " + letter;
                    }
                    wrongLetterCount++;
                }

                //check if the game was won
                if (correctLetterCount == nrOfLetters) {
                    gameWon = true;
                }

                printName();
            }

            System.out.println();
            if (gameWon) {
                System.out.println("Congratulations, you win the game.");
            } else {
                System.out.println("Sorry, you lose. The movie was \"" + chosenMovie + "\".");
            }
        }
    }

    /**
     * Generates a hidden name with the '-' characters instead of letters. Keeps the spaces in the name.
     */
    private void setHiddenName() {
        nrOfLetters = chosenMovie.length();
        correctLetterCount = 0;

        chosenMovieHidden = new String[nrOfLetters];

        for (int i = 0; i < nrOfLetters; i++) {
            chosenMovieHidden[i] = "-";
        }

        for (int i = 0; i < nrOfLetters; i++) {
            if (chosenMovie.substring(i, i + 1).equals(" ")) {
                chosenMovieHidden[i] = " ";
                correctLetterCount++;
            }
        }
    }

    /**
     * Prints the hidden name.
     */
    private void printName() {
        System.out.print("You are guessing: ");

        for (int i = 0; i < nrOfLetters; i++) {
            System.out.print(chosenMovieHidden[i]);
        }
    }
}
