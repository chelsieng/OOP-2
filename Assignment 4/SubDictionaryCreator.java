import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubDictionaryCreator {
    public static void main(String[] args) {
        String word = "";
        int characterCode = 0;
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
                // Skipping digits
                if (word.contains("0") || word.contains("1") || word.contains("2") || word.contains("3") || word.contains("4") || word.contains("5") || word.contains("6") || word.contains("7") || word.contains("8") || word.contains("9")) {
                    continue;
                }
                // Skipping single characters except 'a', 'i', 'A' or 'I'
                if (word.length() == 1 && !((word.equals("a")) || word.equals("A") || word.equals("i") || word.equals("I"))) {
                    continue;
                }
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! File could not be opened/created! Program will terminate now!");
            System.exit(-1);
        }
    }
}
