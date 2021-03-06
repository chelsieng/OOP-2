// -----------------------------------------------------
// Assignment 3
// Question: Task 3-7
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Chelsie Ng - 40071692
 * BibilographyFactory Class which reads and processes a given .bib file (which has one or more articles) and creates 3 different files with the correct reference formats for IEEE, ACM and NJ.
 */
public class BibilographyFactory {
    /**
     * processFilesForValidation method processing the input files and creating the output ones
     */
    public static void processFilesForValidation() {
        String author = "";
        String authorIEEE = ""; //author in IEEE format
        String authorACM = ""; //author in ACM format
        String authorNJ = ""; //author in NJ format
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
        int fileCount = 0; //number of files
        PrintWriter pwIEEE = null;
        PrintWriter pwACM = null;
        PrintWriter pwNJ = null;
        Scanner input = null;
        // Process for 10 files
        for (int i = 1; i < 11; i++) {
            boolean invalid = false;
            int ACMcount = 0; //counting number of ACM articles
            File file = new File("Assignment 3/Input Files/Latex" + i + ".bib");
            File IEEFile = new File("Assignment 3/Output Files/IEEE" + i + ".json");
            File ACMFile = new File("Assignment 3/Output Files/ACM" + i + ".json");
            File NJFile = new File("Assignment 3/Output Files/NJ" + i + ".json");
            // Opening latex file
            try {
                input = new Scanner(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                System.out.println("Could not open input file Latex" + i + ".bib for reading. \n\nPlease check if file exists! Program will terminate after closing any opened files.");
                System.exit(-1);
            }
            // Creating/ opening IEEE, ACM and NJ file
            try {
                pwIEEE = new PrintWriter(new FileOutputStream(IEEFile));
                pwACM = new PrintWriter(new FileOutputStream(ACMFile));
                pwNJ = new PrintWriter(new FileOutputStream(NJFile));
            } catch (FileNotFoundException e) {
                System.out.println("ACM" + i + ".json file could not be opened/created.");
                System.exit(-1);
            }
            //Reading Latex file
            while (input.hasNextLine()) {
                try {
                    String text = input.nextLine();
                    // End of an article
                    if (text.equals("}")) {
                        ACMcount++;
                        String[] splitString = author.split("and");
                        for (int j = 0; j < splitString.length; j++) {
                            authorIEEE = splitString[j] + ", ";
                            authorNJ = splitString[j] + " & ";
                            authorACM = splitString[0];
                            if (j == splitString.length - 1) {
                                authorIEEE = splitString[j];
                                authorNJ = splitString[j];
                            }
                            pwIEEE.print(authorIEEE);
                            pwNJ.print(authorNJ);
                        }
                        // writing in IEEE, ACM and NJ format in respective IEEE, ACM and NJ file
                        pwIEEE.println(". \"" + title + "\", " + journal + ", vol. " + volume + ", no. " + number + ", p. " + pages + ", " + month + " " + year + ".\n");
                        pwACM.println("[" + ACMcount + "]\t\t" + authorACM + " et al. " + year + ". " + title + ". " + journal + ". " + volume + ", " + number + "(" + year + "), " + pages + ". DOI:https://doi.org/" + doi + ".\n");
                        pwNJ.println(". " + title + ". " + journal + ". " + volume + ", " + pages + "(" + year + ").\n");
                    }
                    if (text.contains("@ARTICLE{")) {
                        continue;
                    }
                    text = text.replace("={", "|"); // replacing character "={" with least used character "|"
                    st1 = new StringTokenizer(text, "|"); // using least used character as delimiter
                    // Processing each token and storing in corresponding field variable
                    while (st1.hasMoreTokens()) {
                        st1.nextToken();
                        if (text.contains("author|")) {
                            try {
                                author = st1.nextToken().trim(); //removing white spaces
                                author = author.substring(0, author.length() - 2); //removing "},"
                                if (author.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"author\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("journal|")) {
                            try {
                                journal = st1.nextToken().trim(); //removing white spaces
                                journal = journal.substring(0, journal.length() - 2); //removing "},"
                                if (journal.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"journal\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("title|")) {
                            try {
                                title = st1.nextToken().trim(); //removing white spaces
                                title = title.substring(0, title.length() - 2); //removing "},"
                                if (title.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"title\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("year|")) {
                            try {
                                year = st1.nextToken().trim(); //removing white spaces
                                year = year.substring(0, year.length() - 2); //removing "},"
                                if (year.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"year\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("volume|")) {
                            try {
                                volume = st1.nextToken().trim(); //removing white spaces
                                volume = volume.substring(0, volume.length() - 2); //removing "},"
                                if (volume.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"volume\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("number|")) {
                            try {
                                number = st1.nextToken().trim(); //removing white spaces
                                number = number.substring(0, number.length() - 2); //removing "},"
                                if (number.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"number\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("pages|")) {
                            try {
                                pages = st1.nextToken().trim(); //removing white spaces
                                pages = pages.substring(0, pages.length() - 2); //removing "},"
                                if (pages.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"pages\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("keywords|")) {
                            try {
                                keywords = st1.nextToken().trim(); //removing white spaces
                                keywords = keywords.substring(0, keywords.length() - 2); //removing "},"
                                if (keywords.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"keywords\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("doi|")) {
                            try {
                                doi = st1.nextToken().trim(); //removing white spaces
                                doi = doi.substring(0, doi.length() - 2); //removing "},"
                                if (doi.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"doi\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("ISSN|")) {
                            try {
                                ISSN = st1.nextToken().trim(); //removing white spaces
                                ISSN = ISSN.substring(0, ISSN.length() - 2); //removing "},"
                                if (ISSN.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"ISSN\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                        if (text.contains("month|")) {
                            try {
                                month = st1.nextToken().trim(); //removing white spaces
                                month = month.substring(0, month.length() - 2); //removing "},"
                                if (month.equals("")) {
                                    throw new NoSuchElementException();
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: Empty Field Detected!");
                                System.out.println("----------------------------");
                                System.out.println("Problem detected with input file: " + file);
                                System.out.println("File is invalid: Field \"month\" is empty. Processing stopped at this point. Other empty fields may be present as well!\n");
                                throw new FileInvalidException();
                            }
                        }
                    }

                } catch (FileInvalidException e) {
                    IEEFile.delete();
                    ACMFile.delete();
                    NJFile.delete();
                    invalid = true;
                    fileCount++;
                    break;
                }
            }
            //When file is invalid, move on to next file
            if (invalid) {
                continue;
            }
            pwIEEE.close();
            pwACM.close();
            pwNJ.close();
        } //eoFor
        System.out.println("A total of " + fileCount + " files were invalid, and could not be processed. All other " + (10 - fileCount) + " \"Valid\" files have been created.");
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
                inputStream = new Scanner(new FileInputStream(inputFile));
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println("Could not open input file Latex" + i + ".bib for reading. \n\nPlease check if file exists! Program will terminate after closing any opened files.");
                System.exit(-1);
            }
            //Opening or creating IEEE.json file
            try {
                pwIEEE = new PrintWriter(new FileOutputStream(IEEFile));
            } catch (FileNotFoundException E) { // when IEEE file cannot be created
                System.out.println("IEEE" + i + ".json file could not be opened/created.");
                outputFiles.delete(); //Deleting directory
                System.exit(-1);
            }
            //Opening or creating ACM.json file
            try {
                pwACM = new PrintWriter(new FileOutputStream(ACMFile));
            } catch (FileNotFoundException e) { // when ACM file cannot be created
                System.out.println("ACM" + i + ".json file could not be opened/created.");
                outputFiles.delete(); //Deleting directory
                System.exit(-1);
            }
            //Opening or creating NJ.json file
            try {
                pwNJ = new PrintWriter(new FileOutputStream(NJFile));
            } catch (FileNotFoundException e) { // when NJ file cannot be created
                System.out.println("NJ" + i + ".json file could not be opened/created.");
                outputFiles.delete(); //Deleting directory
                System.exit(-1);
            }
        } //eoFor
        processFilesForValidation();

        Scanner userInput = new Scanner(System.in);
        int invalidCount = 0;
        boolean valid = false;
        while (!valid) {
            //Prompting user to review any file
            System.out.println("\nPlease enter the name of one of the files that you need to review: ");
            String fileName = userInput.nextLine();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Assignment 3/Output Files/" + fileName));
                System.out.println("Here are the contents of the successfully created Jason File: " + fileName + "\n");
                try {
                    String line = reader.readLine();
                    while (line != null) {
                        System.out.println(line);
                        line = reader.readLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error! Problem reading File. Program will now terminate!");
                    System.exit(-1);
                }
                //Closing message
                System.out.println("Goodbye! Hope you have enjoyed creating the needed files using BibilographyFactory.");
                valid = true;
            } catch (FileNotFoundException e) {
                invalidCount++;
                System.out.println("Could not open input file. File does not exist; it could possibly not be created!");
                //No more chances
                if (invalidCount == 2) {
                    System.out.println("Unfortunately, this was your last chance! Program will now terminate!");
                    System.exit(-1);

                } else { //Second chance for user to review file
                    System.out.println("However, you will be allowed another chance to enter file name.");
                    valid = false;
                }
            }
        }
        userInput.close();
    }
}


