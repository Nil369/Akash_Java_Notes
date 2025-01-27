package _2_Constructors_Access_modifiers;

class Coder{
    int id;
    String name;
    // Default Constructor
    public Coder(){
        System.out.println("I'm a default Constructor. I will be automatically called");
    }

    // Parameterized constructor
    public Coder(String s, int i){
        System.out.println("The name of the first employee is : " + s);
        System.out.println("The id of the first employee is : " + i);
    }

    //    Constructor overloaded
    public Coder(String s, int i, int salary){
        System.out.println("The name of the second employee is : " + s);
        System.out.println("The id of the second employee is : " + i);
        System.out.println("The salary of second employee is : " + salary);
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        this.name = n; // "this" keyword refers to the current context of the class
    }

    public void setId(int i){
        this.id = i;
    }

    public int getId(){
        return id;
    }

}

public class _1_Constructors {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Coder obj = new Coder(); // when no arguments are passed it will invoke/call the default constructor
        Coder akash = new Coder("Akash",420);
        Coder Akash = new Coder("Akash Halder",421,1200000);

        // Example of setter & getter methods:
        Coder Nil = new Coder();
        akash.setName("Akash Halder");
        akash.setId(69);

        System.out.println(akash.getName());
        System.out.println(akash.getId());
        // It will be better understood in access_modifiers part

    }
}
