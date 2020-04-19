// -----------------------------------------------------
// Assignment 4
// Question: part 2 - I
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------

import java.util.Scanner;

/**
 * @author Chelsie Ng - 40071692
 * CellPhone Class to store serial number, brand, year and price information
 */
public class CellPhone {
    private long serialNum;
    private String brand;
    private int year;
    private double price;

    /**
     * This is a constructor to initialize a CellPhone object
     *
     * @param serialNum initial serial number
     * @param brand     initial brand name
     * @param year      initial manufacturing year
     * @param price     initial price
     */
    public CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    /**
     * This is a copy constructor
     *
     * @param cellPhone stores the other cellphone being copied
     * @param value     stores unique serial number
     */
    public CellPhone(CellPhone cellPhone, long value) {
        serialNum = value;
        brand = cellPhone.brand;
        year = cellPhone.year;
        price = cellPhone.price;

    }

    /**
     * clone Method
     *
     * @return a deep copy of cellphone
     */
    public CellPhone clone() {
        Scanner userIn = new Scanner(System.in);
        System.out.println("Please enter a new serial number: ");
        long value = userIn.nextLong();
        return new CellPhone(this, value);
    }

    /**
     * get brand of the cellphone
     *
     * @return brand of the cellphone
     */
    public String getBrand() {
        return brand;
    }

    /**
     * get manufacturing year of the cellphone
     *
     * @return manufacturing year of the cellphone
     */
    public int getYear() {
        return year;
    }

    /**
     * get price of the cellphone
     *
     * @return price of the cellphone
     */
    public double getPrice() {
        return price;
    }

    /**
     * get serial number of the cellphone
     *
     * @return serial number of the cellphone
     */
    public long getSerialNum() {
        return serialNum;
    }

    /**
     * set serial number of the cellphone
     *
     * @param serialNum new serial number of the cellphone
     */
    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    /**
     * set brand of the cellphone
     *
     * @param brand new brand of the cellphone
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }


    /**
     * set manufacturing year of the cellphone
     *
     * @param year new manufacturing year of the cellphone
     */
    public void setYear(int year) {
        this.year = year;
    }


    /**
     * set price of the cellphone
     *
     * @param price new price of the cellphone
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
        return "[" + serialNum + ": " + brand + " " + price + "$ " + year + "]";
    }

    /**
     * equals Method
     *
     * @param object stores object being compared
     * @return true if some other cellphone is equal to this cellphone
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            CellPhone cellPhone = (CellPhone) object;
            if (this.brand.equals(cellPhone.brand) && this.year == cellPhone.year && this.price == cellPhone.price) {
                return true;
            }
        }
        return false;
    }

}
