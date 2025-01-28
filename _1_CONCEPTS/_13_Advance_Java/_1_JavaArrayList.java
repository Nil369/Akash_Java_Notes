import java.util.ArrayList;

public class _1_JavaArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>(); // Dynamic Array, Similar to list in PYTHON
        ArrayList<Integer> l2 = new ArrayList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);

        l2.add(11);
        l2.add(12);
        l2.add(13);
        l2.add(14);

        for (int i : l1) {
            System.out.print(i);
            System.out.print(", ");
        }


        System.out.println("\nL1 Array list : "+ l1);
        System.out.println("L2 Array list : " +l2);

        l1.addAll(l2);// Adding another list in previous list

        System.out.println("L1 Array list after merging: "+ l1);
        System.out.println("L2 Array list : " +l2);

        System.out.println("The first occurrence of 3 in l1 is at index : " + l1.indexOf(3));
        System.out.println("The last occurrence of 3 in l1 is at index : " + l1.lastIndexOf(3));



        l1.clear(); // clearing the list
    }
}
