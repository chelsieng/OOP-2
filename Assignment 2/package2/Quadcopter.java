package package2;

public class Quadcopter extends Helicopter {
    private int maxFlyingSpeed;

    //Default Constructor
    public Quadcopter() {
        super();
        maxFlyingSpeed = 0;
    }

    //Parameterized Constructor
    public Quadcopter(String brand, double price, int horsePower, int numOfCylinders, int creationYear, int passengerCapacity, int maxFlyingSpeed) {
        super(brand, price, horsePower, numOfCylinders, creationYear, passengerCapacity);
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    //Copy Constructor
    public Quadcopter(Quadcopter q) {
        this.brand = q.brand;
        this.price = q.price;
        this.horsePower = q.horsePower;
        this.numOfCylinders = q.numOfCylinders;
        this.creationYear = q.creationYear;
        this.passengerCapacity = q.passengerCapacity;
        this.maxFlyingSpeed = q.maxFlyingSpeed;
    }

    //Accessor Method
    public int getMaxFlyingSpeed() {
        return maxFlyingSpeed;
    }

    //Mutator Method
    public void setMaxFlyingSpeed(int maxFlyingSpeed) {
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    //Displaying description and information of quadcopter
    public String toString() {
        return "This quadcopter is manufactured by " + brand + " and was created in " + creationYear + ". It costs $" + price + "0. It has " + horsePower + "hp and a maximum flying speed of " + maxFlyingSpeed + " miles per hour. It has " + numOfCylinders + " sets of cylinders and can hold up to " + passengerCapacity + " passengers.";
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            Quadcopter q = (Quadcopter) object;
            if (this.brand.equals(q.brand)&& this.price == q.price && this.horsePower == q.horsePower && this.numOfCylinders == q.numOfCylinders && this.creationYear == q.creationYear && this.passengerCapacity == q.passengerCapacity && this.maxFlyingSpeed==q.maxFlyingSpeed) {
                return true;
            }
        }
        return false;
    }
}
