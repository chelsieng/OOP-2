import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BibilographyFactory {
    public static void main(String[] args) {
        //Displaying welcome message
        System.out.println("=========================================");
        System.out.println("WELCOME TO CHELSIE'S BIBILOGRAPHY FACTORY");
        System.out.println("=========================================");

        //Opening 10 input files
        for (int i = 1; i < 11; i++) {
            Scanner inputFile = null;
            try {
                inputFile = new Scanner(new FileInputStream("Assignment 3/Files/Latex" + i + ".bib"));
                inputFile.close();
            }
            //when file does not exist
            catch (FileNotFoundException e) {
                System.out.println("Could not open input file Latex" + i + ".bib for reading. \n\nPlease check if file exists! Program will terminate after closing any opened files.");
                System.exit(0);
            }
        }
    }
}
