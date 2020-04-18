import java.util.Scanner;

public class CellPhone {
    private long serialNum;
    private String brand;
    private int year;
    private double price;

    public CellPhone() {
        serialNum = 0;
        brand = "";
        year = 0;
        price = 0.0;
    }

    public CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public CellPhone(CellPhone cellPhone, long value) {
        serialNum = value;
        brand = cellPhone.brand;
        year = cellPhone.year;
        price = cellPhone.price;

    }

    public CellPhone clone() {
        Scanner userIn = new Scanner(System.in);
        System.out.println("Please enter a new serial number: ");
        long value = userIn.nextLong();
        return new CellPhone(this, value);
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "[" + serialNum + ": " + brand + " " + price + "$ " + year + "]";
    }

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
