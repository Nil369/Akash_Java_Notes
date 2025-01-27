package _1_OOP_Basics_Encapsulation;// Learn/Revise the basic Concepts of OOP from the notes

// Creating a class Programmer -> Demonstrating Encapsulation (variables + methods)
class Programmer{
    int _id,salary; // class attributes/variables
    String name,lang;

    // methods
    public void printDetails(){
        System.out.println("\nMy name is "+name);
        System.out.println("My id is "+_id);
        System.out.println("I'm currently learning: "+lang);
        System.out.println("My name is "+salary);
    }

}

public class _1_OOP_Basics {
    public static void main(String[] args) {

        // Creating objects: Can create 'N' number of objects from a class
        Programmer obj = new Programmer();
        Programmer obj1 = new Programmer();

        // Setting values for class attributes
        obj._id = 420;
        obj.name = "Akash";
        obj.lang = "Java";
        obj.salary = 6000000;

        obj1._id = 421;
        obj1.name = "Nil";
        obj1.lang = "JavaScript";
        obj1.salary = 12000000;

        // Accessing class methods:
        obj.printDetails();
        obj1.printDetails();

        // Note: There is a better way of setting attributes at the time of object creation using constructors.
    }
}
