// -----------------------------------------------------
// Assignment 4
// Question: part 1
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chelsie Ng - 40071692
 * SubDictionaryCreator Class that accepts any text file, as input, and creates a sub-dictionary that includes all the words found in that file based on some rules
 */
public class SubDictionaryCreator {
    /**
     * This is the main method that will run the program
     *
     * @param args unused
     */
    public static void main(String[] args) {
        String word = "";
        String filename = "";
        Scanner keyboard = new Scanner(System.in);
        //Welcome message
        System.out.println("Welcome to Chelsie's Sub-Dictionary Creator! \n\nPlease enter the name of the input file: ");
        filename = keyboard.nextLine();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> noDuplicateList = new ArrayList<String>();
        try {
            Scanner reader = new Scanner(new FileInputStream("Assignment 4/" + filename));
            PrintWriter writer = new PrintWriter(new FileOutputStream("Assignment 4/SubDictionary.txt"));
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
                word = word.toUpperCase(); //converting all words to upper case
                list.add(word); // adding all words in array list
            }
            list.remove((char) 32); // Removing space character
            // Removing all duplicates
            for (String element : list) {
                if (!noDuplicateList.contains(element)) {
                    noDuplicateList.add(element);
                }
            }
            writer.println("The document produced this sub-dictionary, which includes " + noDuplicateList.size() + " entries."); //Writing in output file
            noDuplicateList.sort(null); // sorting list in alphabetical order
            int letter = 64;
            for (String element : noDuplicateList) {
                if (element.equals("")) {
                    continue;
                }
                if (element.charAt(0) > letter) {
                    letter = element.charAt(0);
                    writer.println();
                    writer.println((char) letter); //Writing respective letter as separator
                    writer.println("==");
                }
                writer.println(element); //Writing in output file
            }
            reader.close();
            writer.close();
            System.out.println("SubDictionary.txt has been successfully created!\n\nThank you for using Chelsie's Sub-Dictionary Creator!");
        } catch (FileNotFoundException e) {
            System.out.println("Error! File could not be found! Program will terminate now!");
            System.exit(-1);
        }
    }
}
