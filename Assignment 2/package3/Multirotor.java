package package3;

import package2.Helicopter;

public class Multirotor extends Helicopter {
    private int numOfRotors;

    //Default Constructor
    public Multirotor() {
        super();
        numOfRotors = 0;
    }

    //Parameterized Constructor
    public Multirotor(String brand, double price, int horsePower, int numOfCylinders, int creationYear, int passengerCapacity, int numOfRotors) {
        super(brand, price, horsePower, numOfCylinders, creationYear, passengerCapacity);
        this.numOfRotors = numOfRotors;
    }

    //Copy Constructor
    public Multirotor(Multirotor m) {
        this.brand = m.brand;
        this.price = m.price;
        this.horsePower = m.horsePower;
        this.numOfCylinders = m.numOfCylinders;
        this.creationYear = m.creationYear;
        this.passengerCapacity = m.passengerCapacity;
        this.numOfRotors = m.numOfRotors;
    }

    //Accessor Method
    public int getNumOfRotors() {
        return numOfRotors;
    }

    //Mutator Method
    public void setNumOfRotors(int numOfRotors) {
        this.numOfRotors = numOfRotors;
    }

    //Displaying description and information of multirotor
    public String toString() {
        return "This multirotor is manufactured by " + brand + " and was created in " + creationYear + ". It costs $" + price + "0 and has a horse power of " + horsePower + " watt. It has " + numOfCylinders + " cylinders, " + numOfRotors + " rotors and can hold up to " + passengerCapacity + " passengers.";
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            Multirotor m = (Multirotor) object;
            if (this.brand.equals(m.brand) && this.price == m.price && this.horsePower == m.horsePower && this.numOfCylinders == m.numOfCylinders && this.creationYear == m.creationYear && this.passengerCapacity == m.passengerCapacity && this.numOfRotors==m.numOfRotors) {
                return true;
            }
        }
        return false;
    }
}
