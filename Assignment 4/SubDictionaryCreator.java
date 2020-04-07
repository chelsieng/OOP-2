import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubDictionaryCreator {
    public static void main(String[] args) {
        String word = "";
        try {
            Scanner reader = new Scanner(new FileInputStream("Assignment 4/PersonOfTheCentury.txt"));
            // Reading input file word by word
            while (reader.hasNext()) {
                word = reader.next();
                // when word has punctuations
                if (word.contains("?") || word.contains(":") || word.contains("'") || word.contains(",") || word.contains("=") || word.contains(";") || word.contains("!") || word.contains(".")) {
                    // when word has "'s" or "'m"
                    if (word.contains("'")) {
                        word = word.substring(0, word.length() - 1); //removing 's or 'm
                    }
                    word = word.substring(0, word.length() - 1); // removing punctuation
                }
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error! File could not be opened/created! Program will terminate now!");
            System.exit(-1);
        }
    }
}
