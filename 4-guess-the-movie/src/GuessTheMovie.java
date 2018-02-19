/**
 * A guessing game (hangman) where the computer will choose a random movie for the user to guess,
 * and the user gets 6 guesses of which letters the name contains to find out what that movie is.
 *
 * @author  Silver Lumi
 * @version 1.0
 */
public class GuessTheMovie {

    public static void main(String [] args) {
        Game newGame = new Game("movies.txt");
        newGame.playGame();
    }
}
