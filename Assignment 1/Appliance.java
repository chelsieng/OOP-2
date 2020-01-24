// -----------------------------------------------------
// Assignment 1
// Question: part I
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
        return "Type: " + type + "\nBrand: " + brand + "\nSerial Number: " + serialNumber + "\nPrice: " + price;
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


    public static void main(String[] args) {
        System.out.println("Please enter the maximum number of appliances: ");
        Scanner userInput = new Scanner(System.in);
        int maxAppliances = userInput.nextInt();
        int[] inventory = new int[maxAppliances];
        System.out.println("What do you want to do?\n\t1.\tEnter new appliances (password required)");
        System.out.println("\t2.\tChange information of an appliance (password required)");
        System.out.println("\t3.\tDisplay all appliances by a specific brand");
        System.out.println("\t4.\tDisplay all appliances under a certain price.");
        System.out.println("\t5.\tQuit");
        System.out.println("Please enter your choice >");

    }


}