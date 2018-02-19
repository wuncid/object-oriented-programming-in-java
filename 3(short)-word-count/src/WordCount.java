import java.io.File;
import java.util.Scanner;

/**
 * A program that counts the words in a text file and prints the result.
 *
 * @author  Silver Lumi
 * @version 1.0
 */
public class WordCount {

    public static void main(String [] args) throws Exception {
        File file = new File("taleoftwocities.txt");
        Scanner scanner = new Scanner(file);

        int wordCount = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            wordCount  += line.split(" ").length;
        }

        System.out.println("The file contains: " + wordCount + " words.");
    }
}
