// Interfaces in Java:
/*
-> Just like a class in java is a collection of the related methods, an interface in java 
    is a collection of abstract methods.
-> The interface is one more way to achieve abstraction in Java.
-> An interface may also contain constants, default methods, and static methods.
-> All the methods inside an interface must have empty bodies except default methods and static methods.
-> There is no need to write abstract keyword before declaring methods in an interface 
    because an interface is implicitly abstract.
-> An interface cannot contain a constructor (as it cannot be used to create objects)
-> In order to implement an interface, java requires a class to use the implement keyword.

*/

package _4_Abstraction_Interfaces__Polymorphism;
interface Bicycle{
    int a = 69;
    void applyBrake(int decrement);
    void speedUp(int increment);
}
interface HornBicycle{
    int x = 45;
    void blowHornK3g();
    void blowHornMhn();
}
class HeroCycle implements Bicycle,HornBicycle{
    //public int x = 5;
    void blowHorn(){
        System.out.println("Pee Pee Poo Poo");
    }
    @Override
    public void applyBrake(int decrement){
        System.out.println("Applying Brake");
    }
    @Override
    public void speedUp(int increment){
        System.out.println("Applying SpeedUP");
    }
    @Override
    public void blowHornK3g(){
        System.out.println("Kabhi khushi kabhi gum pee pee pee pee");
    }
    @Override
    public void blowHornMhn(){
        System.out.println("Main hoon naa po po po po");
    }

}
public class _2_Interfaces {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        HeroCycle cycle1 = new HeroCycle();
        cycle1.applyBrake(1);

        // We can create properties in Interfaces
        // System.out.println(cycle1.a);
        // System.out.println(cycle1.x);
        System.out.println(Bicycle.a);
        System.out.println(HornBicycle.x);

        // We cannot modify the properties in Interfaces as they are final
        // cycle1.a = 454; // This line would generate a compile-time error
        // System.out.println(cycle1.a);

        cycle1.blowHorn();
        cycle1.blowHornK3g();
        cycle1.blowHornMhn();
    }
}
// Q. Is multiple inheritance allowed in Java?
/*
-> Multiple inheritance faces problems when there exists a method with the same signature in both the superclasses.
-> Due to such a problem, java does not support multiple inheritance directly, but the similar concept can be achieved using interfaces.
-> class can implement multiple interfaces and extend a class at the same time.
*/

// Some Imp points:
//🔸Interfaces in java are a bit like the class but with a significant difference.
//🔸An Interface can only have method signatures field and a default method.
//🔸The class implementing an interface needs to declare the methods ( not field ).
//🔸You can create a reference of an interface but not the object.
//🔸Interface methods are public by default.
