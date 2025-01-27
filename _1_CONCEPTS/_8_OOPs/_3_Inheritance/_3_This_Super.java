// This Keyword:
/*
-> this is a way for us to reference an object of the class which is being created/referenced.
-> It is used to call the default constructor of the same class.
-> this keyword eliminates the confusion between the parameters and the class attributes with the same name
*/

// Super Keyword:
/*
-> super keyword is a reference variable used to refer immediate parent class object.
-> It can be used to refer immediate parent class instance variable.
-> It can be used to invoke the parent class method.
*/

class Vehicle {
    String brand;
    int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand; // Refers to the current object's 'brand'
        this.speed = speed; // Refers to the current object's 'speed'
    }

    public void displayDetails() {
        System.out.println("Vehicle Brand: " + brand);
        System.out.println("Maximum Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    int seatingCapacity;

    Car(String brand, int speed, int seatingCapacity) {
        super(brand, speed); // Refers to the parent class constructor
        this.seatingCapacity = seatingCapacity; // Refers to the current object's 'seatingCapacity'
    }

    public void displayCarDetails() {
        // Displaying parent class details using parent class method
        super.displayDetails();
        // Displaying child class details
        System.out.println("Seating Capacity: " + this.seatingCapacity + " persons"); // Refers to the current object's attribute
    }
}

public class _3_This_Super {
    public static void main(String[] args) {

        Car myCar = new Car("Tesla", 250, 5);
        myCar.displayCarDetails();
    }
}
