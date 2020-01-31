// -----------------------------------------------------
// Assignment 1
// Question: part I and II
// Written by: Chelsie Ng Man King 40071692
// -----------------------------------------------------
/**
 * This program is an appliance tracker. The user will be able to enter new appliances, change information of an appliance,
 * display all appliances by a specific brand and display all appliances under a certain a price.
 * Also, a password is required for entering a new appliance and updating information of an appliance.
 */

import java.util.Scanner;

/**
 * @author Chelsie Ng - 40071692
 * Appliance Class to store type, brand, serial number and price information
 */
public class Appliance {
    private String type;
    private String brand;
    private static long serialNumber = 999999;
    private long serialNum;
    private double price;
    private static int count = 0;

    /**
     * This is a default constructor
     */
    public Appliance() {
        type = null;
        brand = null;
        serialNumber++;
        serialNum = serialNumber;
        price = 1.00;
        count++;
    }

    /**
     * This is a constructor to initialize an Appliance object
     *
     * @param newType  initial type name
     * @param newBrand initial brand name
     * @param newPrice initial price
     */
    public Appliance(String newType, String newBrand, double newPrice) {
        type = newType;
        brand = newBrand;
        serialNumber++;
        serialNum = serialNumber;
        price = newPrice;
        count++;
    }

    /**
     * This is a copy constructor
     *
     * @param app stores the other appliance being copied
     */
    public Appliance(Appliance app) {
        type = app.type;
        brand = app.brand;
        serialNumber = app.serialNumber++;
        serialNum = serialNumber;
        price = app.price;
        count++;
    }

    /**
     * get type of the appliance
     *
     * @return type of the appliance
     */
    public String getType() {
        return type;
    }

    /**
     * get brand of the appliance
     *
     * @return brand of the appliance
     */
    public String getBrand() {
        return brand;
    }

    /**
     * get serial number of the appliance
     *
     * @return serial number of the appliance
     */
    public long getSerialNumber() {
        return serialNum;
    }

    /**
     * get price of the appliance
     *
     * @return price of the appliance
     */
    public double getPrice() {
        return price;
    }

    /**
     * set type of the appliance
     *
     * @param type new type of the appliance
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * set brand of the appliance
     *
     * @param brand new brand of the appliance
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * set price of the appliance
     *
     * @param price new price of the appliance
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * toString Method
     *
     * @return a string representation of the object
     */
    public String toString() {
        return "Appliance Serial # " + serialNum + "\nBrand: " + brand + "\nType: " + type + "\nPrice: $" + price + "0";
    }

    /**
     * findNumberofCreatedAppliances method
     *
     * @return the number of appliances created
     */
    public static int findNumberOfCreatedAppliances() {
        if (count == 0) {
            return 0;
        } else {
            return count;
        }
    }

    /**
     * equals method
     *
     * @param a1 stores the appliance being compared
     * @return indicates whether some other appliance is equal to this one
     */
    public boolean equals(Appliance a1) {
        return (brand.equals(a1.brand) && type.equals(a1.type) && price == a1.price);
    }

    /**
     * showMenu method
     * this displays the main menu
     */
    public static void showMenu() {
        System.out.println("What do you want to do?\n\t1.\tEnter new appliances (password required)");
        System.out.println("\t2.\tChange information of an appliance (password required)");
        System.out.println("\t3.\tDisplay all appliances by a specific brand");
        System.out.println("\t4.\tDisplay all appliances under a certain price.");
        System.out.println("\t5.\tQuit");
        System.out.println("Please enter your choice >");

    }

    /**
     * This is the main method that will run the program
     *
     * @param args unused
     */
    public static void main(String[] args) {
        //Declaring variables
        int passwordCount = 0; //Number of passwords entered
        int choice = 0; //choice number
        int applianceCount = 0; //Number of appliances
        int spaceCount = 0; //Number of empty spaces in inventory
        int fullCount = 0; //Number of occupied spaces in inventory
        int serialNumLocation = 0; //Location of serial number
        boolean serialNumExists = false; //if serial number exists
        long serialNum = 0; //Serial number of appliance
        String password = null;
        String brand = null;
        String type = null;
        double price = 0;
        boolean empty = true;
        boolean exit = false;
        Scanner userInput = new Scanner(System.in);
        int maxAppliances = 0;
        // Displaying welcome message
        System.out.println("___________________________________________________________________");
        System.out.println("\n\t\t\t  WELCOME TO CHELSIE'S APPLIANCE TRACKER");
        System.out.println("___________________________________________________________________");
        System.out.println("Please enter the maximum number of appliances: ");
        maxAppliances = userInput.nextInt();
        Appliance[] inventory = new Appliance[maxAppliances];
        while (true) {
            exit = false;
            showMenu();
            choice = userInput.nextInt();
            while (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5)) {
                showMenu();
                choice = userInput.nextInt();
            }
            //Enter new appliances
            while (choice == 1) {
                System.out.println("Please enter your password (3 attempts only)");
                password = userInput.next();
                //When password is incorrect
                while (!(password.equals("c249")) || passwordCount >= 3) {
                    passwordCount++;
                    System.out.println("The password you've entered is incorrect.");
                    password = userInput.next();
                    if (password.equals("c249")) break;
                    if ((passwordCount == 2 || passwordCount == 4 || passwordCount == 6)) {
                        System.out.println("This was your last attempt.");
                        showMenu();
                        choice = userInput.nextInt();
                    }
                    while (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5)) {
                        showMenu();
                        choice = userInput.nextInt();
                    }
                    if ((passwordCount == 2 || passwordCount == 4 || passwordCount == 6)) {
                        break;
                    }
                    //Terminate program if 12 failed attempts
                    if (passwordCount == 8) {
                        System.out.println("Program detected suspicious activities and will terminate immediately!");
                        System.exit(0);
                    }
                }
                //When password is correct
                while (password.equals("c249")) {
                    passwordCount = 0;
                    System.out.println("How many appliances do you want to enter?");
                    applianceCount = userInput.nextInt();
                    //Checking if inventory is free of space
                    if (applianceCount <= maxAppliances) {
                        for (int i = 0; i < inventory.length; i++) {
                            if (inventory[i] == null) {
                                spaceCount++;
                            } else {
                                fullCount++;
                            }
                        }
                        //Add appliance if there is enough space
                        if (spaceCount >= applianceCount) {
                            for (int i = 0; i < inventory.length; i++) {
                                inventory[i] = new Appliance();
                            }
                            System.out.println(applianceCount + " appliances have been added to inventory.");
                            exit = true;

                        }
                        //When there is not enough space
                        else {
                            System.out.println("This inventory does not support this amount of appliances.");
                            System.out.println("There is only " + spaceCount + " remaining place(s) available in the inventory.");
                            exit = true;

                        }
                    }
                    //When number of appliances exceeds number of maximum appliance
                    else {
                        System.out.println("This inventory does not support this amount of appliances.");
                        exit = true;

                    }
                    break;
                }
                if (exit) {
                    break; //go back to main menu
                }

            }
            // Change information of an appliance
            while (choice == 2) {
                passwordCount = 0;
                System.out.println("Please enter your password (3 attempts only)");
                password = userInput.next();
                //When password is incorrect
                while (!(password.equals("c249"))) {
                    passwordCount++;
                    System.out.println("The password you've entered is incorrect.");
                    password = userInput.next();
                    if ((passwordCount >= 2) && !(password.equals("c249"))) {
                        System.out.println("This was your last attempt.");
                        showMenu();
                        passwordCount = 0;
                        choice = userInput.nextInt();
                    }
                    while (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5)) {
                        showMenu();
                        choice = userInput.nextInt();
                    }
                    if ((passwordCount % 2 == 0)) {
                        break;
                    }
                }
                //When password is correct
                while ((password.equals("c249"))) {
                    System.out.println("Please enter the serial number of the appliance you wish to update");
                    serialNum = userInput.nextLong();
                    // Checking if serial number exists
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] != null) {
                            if (inventory[i].getSerialNumber() == serialNum) {
                                serialNumExists = true;
                                serialNumLocation = i;
                                break;
                            } else {
                                serialNumExists = false;
                            }
                        }
                    }
                    // When serial number does not exist
                    if (serialNumExists == false) {
                        System.out.println("Oops! There is no appliance with that serial number.\n\t1.Please re-enter another serial number\n\t2.Quit this operation and go back to the main menu");
                        choice = userInput.nextInt();
                        while (!(choice == 1 || choice == 2)) {
                            System.out.println("Oops! There is no appliance with that serial number.\n\t1.Please re-enter another serial number\n\t2.Quit this operation and go back to the main menu");
                            choice = userInput.nextInt();
                        }
                        // Re-enter another serial number
                        if (choice == 1) {
                            System.out.println("Please re-enter >");
                            serialNum = userInput.nextLong();
                            //Checking if serial number exists
                            for (int i = 0; i < inventory.length; i++) {
                                inventory[i].getSerialNumber();
                                if (inventory[i].getSerialNumber() == serialNum) {
                                    serialNumExists = true;
                                    serialNumLocation = i;
                                    break;
                                } else {
                                    serialNumExists = false;
                                    System.out.println("Sorry there is no appliance with that serial number");
                                    break;
                                }
                            }
                        }
                        //Go back to main menu
                        if (choice == 2) {
                            exit = true;
                            break;
                        }
                    }
                    //When serial number exists
                    while (serialNumExists == true) {
                        System.out.println(inventory[serialNumLocation].toString());
                        System.out.println("What information would you like to change?\n\t1. brand\n\t2. type\n\t3. price\n\t4.Quit\nEnter your choice >");
                        choice = userInput.nextInt();
                        //Updating brand name
                        while (choice == 1) {
                            System.out.println("Please enter the brand name");
                            brand = userInput.next();
                            inventory[serialNumLocation].setBrand(brand);
                            break;
                        }
                        //Updating type of appliance
                        while (choice == 2) {
                            System.out.println("Please enter the type of appliance");
                            type = userInput.nextLine() + userInput.nextLine();
                            while (type.equalsIgnoreCase("fridge") || type.equalsIgnoreCase("air conditioner") || type.equalsIgnoreCase("washer") || type.equalsIgnoreCase("dryer") || type.equalsIgnoreCase("freezer") || type.equalsIgnoreCase("stove") || type.equalsIgnoreCase("dishwasher") || type.equalsIgnoreCase("water heaters") || type.equalsIgnoreCase("microwave")) {
                                inventory[serialNumLocation].setType(type);
                                if (type.equalsIgnoreCase("fridge") || type.equalsIgnoreCase("air conditioner") || type.equalsIgnoreCase("washer") || type.equalsIgnoreCase("dryer") || type.equalsIgnoreCase("freezer") || type.equalsIgnoreCase("stove") || type.equalsIgnoreCase("dishwasher") || type.equalsIgnoreCase("water heaters") || type.equalsIgnoreCase("microwave")) {
                                    break;
                                }
                            }
                            break;
                        }
                        //Updating price value
                        while (choice == 3) {
                            System.out.println("Please enter the price value");
                            price = userInput.nextDouble();
                            inventory[serialNumLocation].setPrice(price);
                            break;
                        }
                        //Going back to main menu
                        while (choice == 4) {
                            exit = true;
                            break;
                        }
                        if (exit) {
                            break;
                        }
                    }
                    if (exit) {
                        break;
                    }
                }
                if (exit) {
                    break; //going back to main menu
                }
            }
            //Display all appliances by a specific brand
            while (choice == 3) {
                System.out.println("Please enter a brand name");
                String brandName = userInput.next() + userInput.nextLine();
                Boolean brandExists = false;
                //Checking whether brand name exists
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] != null && brandName.equals(inventory[i].getBrand())) {
                        brandExists = true;
                        empty = false;
                        System.out.println(inventory[i].toString()); //displaying all info on appliance by brand name

                    }
                }
                // When brand name doesn't exist
                if (empty == true && brandExists == false) {
                    System.out.println("Sorry, there is no appliance with this brand");
                    empty = true;
                    break;
                }
                //When brand name exist
                if (brandExists == true && empty == false) {
                    break;
                }
            }
            //Display all appliances under a certain price
            while (choice == 4 && exit == false) {
                System.out.println("Please enter a value representing a price");
                price = userInput.nextDouble();
                boolean cheaper = false;
                //Checking if price is lower than entered price by user
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i].getPrice() != 1.00 && price > inventory[i].getPrice()) {
                        cheaper = true;
                        System.out.println(inventory[i].toString()); //Displaying all info about appliances under price entered by user
                        empty = false;

                    }
                }
                //When there is no appliances cheaper than price entered by user
                if (cheaper == false && empty == false) {
                    System.out.println("Sorry, there is no appliance cheaper than the value entered");
                    empty = true;
                } else break;

            }
            //Closing message
            if (choice == 5) {
                System.out.println("----------THANK YOU FOR USING CHELSIE'S APPLIANCE TRACKER----------");
                break;
            }
            choice = 0;
        }
    }
}
