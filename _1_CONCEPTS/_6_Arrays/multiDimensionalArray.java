
public class multiDimensionalArray {

    public static void main(String[] args) {
        // int [] marks; // A 1-D array in Java

        int[][] flats; // A 2-D array in Java
        flats = new int[2][3]; // 2-rows & 3-columns

        // Ground-floor => 0th floor Room Nos.
        flats[0][0] = 101;
        flats[0][1] = 102;
        flats[0][2] = 103;

        // 1st-floor Room Nos.
        flats[1][0] = 201;
        flats[1][1] = 202;
        flats[1][2] = 203;


        // Printing Multi-Dimentional Array (Method 1):
        System.out.println("\n Printing Array Elements using Method 1: ");

        for (int i = 0; i < flats.length; i++) {
            for (int j = 0; j < flats[i].length; j++) {
                System.out.print(flats[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        
        // Method 2:
        System.out.println("\n Printing Array Elements using Method 2: ");

        for (int[] flat : flats) {
            for (int j = 0; j < flat.length; j++) {
                System.out.print(flat[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
