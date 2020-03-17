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
        for (int i = 1; i < 12; i++) {
            File outputFiles = new File("Assignment 3/Output Files");
            File inputFile = new File("Assignment 3/Input Files/Latex" + i + ".bib");
            File IEEFile = new File("Assignment 3/Output Files/IEEE" + i + ".json");
            File ACMFile = new File("Assignment 3/Output Files/ACM" + i + ".json");
            File NJFile = new File("Assignment 3/Output Files/NJ" + i + ".json");
            Scanner inputStream = null;
            PrintWriter pwIEEE = null;
            PrintWriter pwACM = null;
            PrintWriter pwNJ = null;
            try {
                inputStream = new Scanner(inputFile);//Opening input file
                pwIEEE = new PrintWriter(new FileOutputStream(IEEFile)); //opening or creating IEEE.json file
                pwACM = new PrintWriter(new FileOutputStream(ACMFile)); //opening or creating ACM.json file
                pwNJ = new PrintWriter(new FileOutputStream(NJFile)); //opening or creating NJ.json file
            } catch (FileNotFoundException e) {
                if (!inputFile.exists()) {
                    System.out.println("Could not open input file Latex" + i + ".bib for reading. \n\nPlease check if file exists! Program will terminate after closing any opened files.");
                    System.exit(0);
                }
                // when IEEE file cannot be created
                if (IEEFile.exists()) {
                    System.out.println("IEEE" + i + ".json file could not be opened/created.");
                    outputFiles.delete(); //Deleting directory
                    inputStream.close();
                    System.exit(0);
                }
                // when ACM file cannot be created
                if (ACMFile.exists()) {
                    System.out.println("ACM" + i + ".json file could not be opened/created.");
                    outputFiles.delete(); //Deleting directory
                    inputStream.close();
                    System.exit(0);
                }
                // when NJ file cannot be created
                if (NJFile.exists()) {
                    System.out.println("NJ" + i + ".json file could not be opened/created.");
                    outputFiles.delete(); //Deleting directory
                    inputStream.close();
                    System.exit(0);
                }
            } finally {
                inputStream.close();
                pwIEEE.close();
                pwACM.close();
                pwNJ.close();
            }

        }
    }
}
