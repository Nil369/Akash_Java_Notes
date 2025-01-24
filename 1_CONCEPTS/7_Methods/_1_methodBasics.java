public class _1_methodBasics {

    // Methods are basically functions inside a class. We write Methods to seperate our LOGIC
    // And most importanly apply DRY (Do not Repeat Yourself) Principle
    
    static int logic(int x, int y){
        int z;
        if(x>y){
            z = x+y;
        }
        else {
            z = (x +y) * 5;
        }
        // x = 566;
        return z;
    }

    // When a method is not marked as static, it becomes an instance method. 
    // This means it belongs to the specific instance of the class rather than the class itself.

    // I mean't without the static keyword, methods in Java treats this methods similarly to those from other classes 
    // that we import and use by creating objects/instances, for ex: the Scanner class. 

    int logic_obj(int x, int y){
        int z;
        if(x>y){
            z = x+y;
        }
        else {
            z = (x +y) * 5;
        }
        // x = 566;
        return z;
    }
    

    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        int c;


        // Method invocation using Object creation:Instance Binding: 
        // To call a non-static method, we must first create an instance of the class. 
        int res;
        _1_methodBasics obj = new _1_methodBasics();
        res = obj.logic_obj(10, 6);
        System.out.println(res);


        // With Static method we don't have to create an object!
        c = logic(a, b);

        System.out.println(a + " "+ b);
        int a1 = 2;
        int b1 = 1;
        int c1;
        c1 = logic(a1, b1);
        System.out.println(c);
        System.out.println(c1);
    }
}
