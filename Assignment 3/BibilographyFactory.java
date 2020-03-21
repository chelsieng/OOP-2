import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BibilographyFactory {
    public static void processFilesForValidation() {
        for (int i = 1; i < 11; i++) {
            String author = "";
            String journal = "";
            String title = "";
            String year = "";
            String volume = "";
            String number = "";
            String pages = "";
            String keywords = "";
            String doi = "";
            String ISSN = "";
            String month = "";
            StringTokenizer st1 = null;
            int invalid = 0;
            File file = new File("Assignment 3/Input Files/Latex" + i + ".bib");
            File IEEFile = new File("Assignment 3/Output Files/IEEE" + i + ".json");
            File ACMFile = new File("Assignment 3/Output Files/ACM" + i + ".json");
            File NJFile = new File("Assignment 3/Output Files/NJ" + i + ".json");
            PrintWriter pwIEEE = null;
            PrintWriter pwACM = null;
            PrintWriter pwNJ = null;
            Scanner input = null;
            try {
                input = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("Could not open input file Latex" + i + ".bib for reading. \n\nPlease check if file exists! Program will terminate after closing any opened files.");
                System.exit(0);
            }
            while (input.hasNextLine()) {
                try {
                    String text = input.nextLine();
                    st1 = new StringTokenizer(text, "={},");
                    while (st1.hasMoreTokens()) {
                        if (text.contains("author")) {
                            try {
                                author = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"author\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("journal")) {
                            try {
                                journal = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"journal\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("title")) {
                            try {
                                title = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"title\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("year")) {
                            try {
                                year = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"year\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("volume")) {
                            try {
                                volume = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"volume\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("number")) {
                            try {
                                number = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"number\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("pages")) {
                            try {
                                pages = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"pages\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("keywords")) {
                            try {
                                keywords = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"keywords\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("doi")) {
                            try {
                                doi = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"doi\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("ISSN")) {
                            try {
                                ISSN = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"ISSN\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("month")) {
                            try {
                                month = st1.nextToken();
                            } catch (Exception e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("\nProblem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"month\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                    }
                } catch (FileInvalidException e) {
                    file.delete();
                    IEEFile.delete();
                    ACMFile.delete();
                    NJFile.delete();
                }
            }

        }
    }

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
                System.exit(0);
            }
            //Opening or creating ACM.json file
            try {
                pwACM = new PrintWriter(new FileOutputStream(ACMFile));
            } catch (FileNotFoundException e) { // when ACM file cannot be created
                System.out.println("ACM" + i + ".json file could not be opened/created.");
                outputFiles.delete(); //Deleting directory
                System.exit(0);
            }
            //Opening or creating NJ.json file
            try {
                pwNJ = new PrintWriter(new FileOutputStream(NJFile));
            } catch (FileNotFoundException e) { // when NJ file cannot be created
                System.out.println("NJ" + i + ".json file could not be opened/created.");
                outputFiles.delete(); //Deleting directory
                System.exit(0);
            }
        }
    }
}

