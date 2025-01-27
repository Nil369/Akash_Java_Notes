//Method Overriding in Java:
/*
-> If the child class implements the same method present in the parent class again, it is known as method overriding.
-> Method overriding helps us to classify a behavior that is specific to the child class.
-> The subclass can override the method of the parent class only when the method is not declared as final.
-> The method in the child class must have the same name, return type, and parameters as the method in the parent class.
*/
class MyVehicle {
    String brand;
    int speed;

    MyVehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Vehicle Brand: " + brand);
        System.out.println("Maximum Speed: " + speed + " km/h");
    }
}

class MyCar extends MyVehicle {
    int seatingCapacity;

    MyCar(String brand, int speed, int seatingCapacity) {
        super(brand, speed); // Initialize parent class attributes
        this.seatingCapacity = seatingCapacity; // Initialize child class attribute
    }

    // Overriding the displayDetails method of the Vehicle class
    @Override
    public void displayDetails() {
        // Displaying additional details specific to Car
        super.displayDetails(); // Optionally call the parent class method
        System.out.println("Seating Capacity: " + seatingCapacity + " persons");
    }
}

public class _4_Method_overRiding {
    public static void main(String[] args) {

        MyVehicle myVehicle = new MyVehicle("Generic Brand", 120);
        MyCar myCar = new MyCar("Tesla", 250, 5);

        // Call displayDetails on the Vehicle object
        System.out.println("Vehicle Details:");
        myVehicle.displayDetails();

        // Call displayDetails on the Car object (overridden method)
        System.out.println("\nCar Details:");
        myCar.displayDetails();
    }
}
