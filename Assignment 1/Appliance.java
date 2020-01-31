// -----------------------------------------------------
// Assignment 1
// Question: part I and II
// Written by: Chelsie Ng Man King 40071692
// -----------------------------------------------------

import java.util.Scanner;

public class Appliance {
    private String type;
    private String brand;
    private static long serialNumber = 999999;
    private long serialNum;
    private double price;
    private static int count = 0;

    // Default Constructor
    public Appliance() {
        type = null;
        brand = null;
        serialNumber++;
        serialNum = serialNumber;
        price = 1.00;
        count++;
    }

    //Parametrized Constructor
    public Appliance(String newType, String newBrand, double newPrice) {
        type = newType;
        brand = newBrand;
        serialNumber++;
        serialNum = serialNumber;
        price = newPrice;
        count++;
    }

    //Copy Constructor
    public Appliance(Appliance app) {
        type = app.type;
        brand = app.brand;
        serialNumber = app.serialNumber++;
        serialNum = serialNumber;
        price = app.price;
        count++;
    }

    //Accessors Method
    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public long getSerialNumber() {
        return serialNum;
    }

    public double getPrice() {
        return price;
    }

    //Mutator Method
    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //toString Method
    public String toString() {
        return "Appliance Serial # " + serialNum + "\nBrand: " + brand + "\nType: " + type + "\nPrice: $" + price + "0";
    }

    //Counting the number of appliances
    public static int findNumberOfCreatedAppliances() {
        if (count == 0) {
            return 0;
        } else {
            return count;
        }
    }

    // equals Method
    public boolean equals(Appliance a1) {
        return (brand.equals(a1.brand) && type.equals(a1.type) && price == a1.price);
    }

    //Display main menu
    public static void showMenu() {
        System.out.println("What do you want to do?\n\t1.\tEnter new appliances (password required)");
        System.out.println("\t2.\tChange information of an appliance (password required)");
        System.out.println("\t3.\tDisplay all appliances by a specific brand");
        System.out.println("\t4.\tDisplay all appliances under a certain price.");
        System.out.println("\t5.\tQuit");
        System.out.println("Please enter your choice >");

    }

    public static void main(String[] args) {
        //Declaring variables
        int passwordCount = 0;
        int choice = 0;
        int applianceCount = 0;
        int spaceCount = 0;
        int fullCount = 0;
        int serialNumLocation = 0;
        boolean serialNumExists = false;
        long serialNum = 0;
        String password = null;
        String brand = null;
        String type = null;
        double price = 0;
        boolean empty = true;
        boolean exit = false;
        Scanner userInput = new Scanner(System.in);
        int maxAppliances = 0;
        // Welcome message
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
            while (choice == 1) {
                System.out.println("Please enter your password (3 attempts only)");
                password = userInput.next();
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
                    if (passwordCount == 8) {
                        System.out.println("Program detected suspicious activities and will terminate immediately!");
                        System.exit(0);
                    }
                }
                while (password.equals("c249")) {
                    passwordCount = 0;
                    System.out.println("How many appliances do you want to enter?");
                    applianceCount = userInput.nextInt();
                    if (applianceCount <= maxAppliances) {
                        for (int i = 0; i < inventory.length; i++) {
                            if (inventory[i] == null) {
                                spaceCount++;
                            } else {
                                fullCount++;
                            }
                        }
                        if (spaceCount >= applianceCount) {
                            for (int i = 0; i < inventory.length; i++) {
                                inventory[i] = new Appliance();
                            }
                            System.out.println(applianceCount + " appliances have been added to inventory.");
                            exit = true;

                        } else {
                            System.out.println("This inventory does not support this amount of appliances.");
                            System.out.println("There is only " + spaceCount + " remaining place(s) available in the inventory.");
                            exit = true;

                        }
                    } else {
                        System.out.println("This inventory does not support this amount of appliances.");
                        exit = true;

                    }
                    break;
                }
                if (exit) {
                    break;
                }

            }


            while (choice == 2) {
                passwordCount = 0;
                System.out.println("Please enter your password (3 attempts only)");
                password = userInput.next();
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

                while ((password.equals("c249"))) {
                    System.out.println("Please enter the serial number of the appliance you wish to update");
                    serialNum = userInput.nextLong();
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
                    if (serialNumExists == false) {
                        System.out.println("Oops! There is no appliance with that serial number.\n\t1.Please re-enter another serial number\n\t2.Quit this operation and go back to the main menu");
                        choice = userInput.nextInt();
                        while (!(choice == 1 || choice == 2)) {
                            System.out.println("Oops! There is no appliance with that serial number.\n\t1.Please re-enter another serial number\n\t2.Quit this operation and go back to the main menu");
                            choice = userInput.nextInt();
                        }
                        if (choice == 1) {
                            System.out.println("Please re-enter >");
                            serialNum = userInput.nextLong();
                            for (int i = 0; i < inventory.length; i++) {
                                inventory[i].getSerialNumber();
                                if (inventory[i].getSerialNumber() == serialNum) {
                                    serialNumExists = true;
                                    serialNumLocation = i;
                                    break;
                                } else {
                                    serialNumExists = false;
                                }
                            }
                        }
                        if (choice == 2) {
                            exit = true;
                            break;
                        }
                    }

                    while (serialNumExists == true) {
                        System.out.println(inventory[serialNumLocation].toString());
                        System.out.println("What information would you like to change?\n\t1. brand\n\t2. type\n\t3. price\n\t4.Quit\nEnter your choice >");
                        choice = userInput.nextInt();
                        while (choice == 1) {
                            System.out.println("Please enter the new information");
                            //two words
                            brand = userInput.next();
                            inventory[serialNumLocation].setBrand(brand);
                            break;
                        }
                        while (choice == 2) {
                            System.out.println("Please enter the new information");
                            type = userInput.nextLine() + userInput.nextLine();
                            while (type.equalsIgnoreCase("fridge") || type.equalsIgnoreCase("air conditioner") || type.equalsIgnoreCase("washer") || type.equalsIgnoreCase("dryer") || type.equalsIgnoreCase("freezer") || type.equalsIgnoreCase("stove") || type.equalsIgnoreCase("dishwasher") || type.equalsIgnoreCase("water heaters") || type.equalsIgnoreCase("microwave")) {
                                inventory[serialNumLocation].setType(type);
                                if (type.equalsIgnoreCase("fridge") || type.equalsIgnoreCase("air conditioner") || type.equalsIgnoreCase("washer") || type.equalsIgnoreCase("dryer") || type.equalsIgnoreCase("freezer") || type.equalsIgnoreCase("stove") || type.equalsIgnoreCase("dishwasher") || type.equalsIgnoreCase("water heaters") || type.equalsIgnoreCase("microwave")) {
                                    break;
                                }
                            }
                            break;
                        }
                        while (choice == 3) {
                            System.out.println("Please enter the new information");
                            price = userInput.nextDouble();
                            inventory[serialNumLocation].setPrice(price);
                            break;
                        }
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
                    break;
                }
            }


            while (choice == 3) {
                System.out.println("Please enter a brand name");
                String brandName = userInput.next() + userInput.nextLine();
                Boolean brandExists = false;
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] != null && brandName.equals(inventory[i].getBrand())) {
                        brandExists = true;
                        empty = false;
                        System.out.println(inventory[i].toString());

                    }
                }
                if (empty == true && brandExists == false) {
                    System.out.println("Sorry, there is no appliance with this brand");
                    empty = true;
                }
                if (brandExists == true && empty == false) {
                    break;
                }
            }
            while (choice == 4 && exit == false) {
                System.out.println("Please enter a value representing a price");
                price = userInput.nextDouble();
                boolean cheaper = false;
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] != null && price > inventory[i].getPrice()) {
                        cheaper = true;
                        System.out.println(inventory[i].toString());
                        empty = false;

                    }
                }
                if (cheaper == false && empty == false) {
                    System.out.println("Sorry, there is no appliance cheaper than the value entered");
                    empty = true;
                } else break;

            }

            if (choice == 5) {
                System.out.println("----------THANK YOU FOR USING CHELSIE'S APPLIANCE TRACKER----------");
                break;
            }
            choice = 0;
        }
    }
}
