import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BibilographyFactory {
    public static void main(String[] args) {
        //Displaying welcome message
        System.out.println("=========================================");
        System.out.println("WELCOME TO CHELSIE'S BIBILOGRAPHY FACTORY");
        System.out.println("=========================================");
        //Opening 10 input files
        for (int i = 1; i < 11; i++) {
            File outputFiles = new File("Assignment 3/Output Files");
            File inputFile = new File("Assignment 3/Input Files/Latex" + i + ".bib");
            File IEEFile = new File("Assignment 3/Output Files/IEEE" + i + ".json");
            File ACMFile = new File("Assignment 3/Output Files/ACM" + i + ".json");
            File NJFile = new File("Assignment 3/Output Files/NJ" + i + ".json");
            Scanner inputStream = null;
            PrintWriter pwIEEE = null;
            PrintWriter pwACM = null;
            PrintWriter pwNJ = null;
            //Opening input file
            try {
                inputStream = new Scanner(inputFile);
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println("Could not open input file Latex" + i + ".bib for reading. \n\nPlease check if file exists! Program will terminate after closing any opened files.");
                System.exit(0);
            }
            //Opening or creating IEEE.json file
            try {
                pwIEEE = new PrintWriter(new FileOutputStream(IEEFile));
            } catch (FileNotFoundException E) { // when IEEE file cannot be created
                System.out.println("IEEE" + i + ".json file could not be opened/created.");
                outputFiles.delete(); //Deleting directory
                inputStream.close();
                System.exit(0);
            }
            //Opening or creating ACM.json file
            try {
                pwACM = new PrintWriter(new FileOutputStream(ACMFile));
            } catch (FileNotFoundException e) { // when ACM file cannot be created
                System.out.println("ACM" + i + ".json file could not be opened/created.");
                outputFiles.delete(); //Deleting directory
                inputStream.close();
                System.exit(0);
            }
            //Opening or creating NJ.json file
            try {
                pwNJ = new PrintWriter(new FileOutputStream(NJFile));
            } catch (FileNotFoundException e) { // when NJ file cannot be created
                System.out.println("NJ" + i + ".json file could not be opened/created.");
                outputFiles.delete(); //Deleting directory
                inputStream.close();
                System.exit(0);
            }
        }
    }
}

