// Access Modifiers specify where a property/method is accessible.

// Private modifiers can't be accessed by its own Objects
// Even the subclasses derived from it can't also access the private attributes of it's Parent class


package _2_Constructors_Access_modifiers;

class Employee{
    private int id;
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setId(int i){
        this.id = i;
    }
    public int getId(){
        return id;
    }
}

public class _2_Access_Modifiers {
    public static void main(String[] args) {
        Employee raunak = new Employee();
        // harry.id = 45;
        // harry.name = "Raunak Ghosh"; --> Throws an error due to private access modifier

        // Therefore, we use Getter & Setter Methods for the accessing & setting the private class attributes,
        // Cause Outside the class it doesn't give access. But Inside it class we have the attributes access.
        // Thus, we use the "this" keyword to refer to the current context of the class & access & set its value.
        raunak.setName("Raunak Ghosh");
        System.out.println(raunak.getName());
        raunak.setId(234);
        System.out.println(raunak.getId());
    }
}
