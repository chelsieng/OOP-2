package package1;

public class Airplane {
    protected String brand;
    protected double price;
    protected int horsePower;

    //Default constructor
    public Airplane() {
        brand = "";
        price = 0.00;
        horsePower = 0;
    }

    //Parameterized constructor
    public Airplane(String brand, double price, int horsePower) {
        this.brand = brand;
        this.price = price;
        this.horsePower = horsePower;
    }

    //Copy constructor
    public Airplane(Airplane a) {
        this.brand = a.brand;
        this.price = a.price;
        this.horsePower = a.horsePower;
    }

    //Accessor Method
    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getHorsePower() {
        return horsePower;
    }

    //Mutator Method
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    //Displaying description and information of airplane
    public String toString() {
        return "This airplane is manufactured by " + brand + ". It costs $" + price + "0 and has a horse power of " + horsePower + " watt.";
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            Airplane a = (Airplane) object;
            if (this.brand.equals(a.brand) && this.price == a.price && this.horsePower == a.horsePower) {
                return true;
            }
        }
        return false;
    }
}
