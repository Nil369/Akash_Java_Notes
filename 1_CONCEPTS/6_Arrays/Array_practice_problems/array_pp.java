package Array_practice_problems;

/* PRACTICE PROBLEMS:
1. Create an array of 5 floats and calculate their sum.
2. Write a program to find out whether a given integer is present in an array or not.
3. Calculate the average marks from an array containing marks of all students in physics using a for-each loop.
4. Create a Java program to add two matrices of size 2x3.
5. Write a Java program to reverse an array.
6. Write a Java program to find the maximum element in an array.
7. Write a Java program to find the maximum element in a Java array.
8. Write a Java program to find whether an array is sorted or not.
9. Write a Java Program to sort an array
*/

import java.util.Arrays;

public class array_pp {
    public static void main(String[] args) {
        
        //SOLUTION 1: Create an array of 5 floats and calculate their sum.
        float [] marks = {80.5f,90.00f,85.6f,95.5f,82.5f};
        float sum = 0;
        for(float elem:marks){
            sum +=elem;
        }
        System.out.println("Total Marks: "+sum);

        //SOLUTION 2: Write a program to find out whether a given integer is present in an array or not.
        int [] studMarks = {80,45,40,90,100};
        int num = 100;
        boolean inArray = false;

        for (int elem: studMarks) {
            if(num == elem){
                inArray = true;
                break;
            }
        }
        if (inArray){
            System.out.println("Congrats!!! You topped the exam !");
        }
        else{
            System.out.println("You did well buddy!");
        }

        // SOLUTION 3: Calculate the average marks from an array containing marks of all students in physics using a for-each loop.
        float [] studentMarks = {45.7f, 67.8f, 63.4f, 99.2f, 100.0f};
        float mark_sum = 0,avg;
        for(float element:studentMarks){
            mark_sum = mark_sum + element;
        }
        avg = mark_sum/marks.length;
        System.out.println("The value of average marks is " + avg);

        // SOLUTION 4: Create a Java program to add two matrices of size 2x3.
        int [][] mat1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int [][] mat2 = {
                {2, 6, 13},
                {3, 7, 1}
        };
        int [][] result = {
                {0, 0, 0},
                {0, 0, 0}
        };

        for (int i=0;i<mat1.length;i++){ // row number of times
            for (int j=0;j<mat1[i].length;j++) { // column number of time
                System.out.format(" Setting value for i=%d and j=%d\n", i, j);
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        // Printing the elements of a 2-D Array
        for (int i=0;i<mat1.length;i++){ // row number of times
            for (int j=0;j<mat1[i].length;j++) { // column number of time
                System.out.print(result[i][j] + " ");
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
            System.out.println(); // Prints a new line
        }

        // SOLUTION 5: Write a Java program to reverse an array.
        int [] arr = {1, 21, 3, 4, 5, 34, 67};
        int l = arr.length;
        int n = Math.floorDiv(l, 2);
        int temp;
        for(int i=0; i<n; i++){
            // Swap a[i] and a[l-1-i]
            // a   b   temp
            // |4| |3| ||
            temp = arr[i];
            arr[i] = arr[l-i-1];
            arr[l-i-1] = temp;
        }
        // Printing the array
        for(int element: arr){
            System.out.print(element + " ");
        }

         // SOLUTION 6: Write a Java program to find the maximum element in an array.
        int [] array = {1, 2100, 3, 455, 5, 34, 67};
        System.out.printf("\nMIN_VALUE of Integer: %d",Integer.MIN_VALUE);
        System.out.printf("\nMAX_VALUE of Integer: %d",Integer.MAX_VALUE);
        int max = Integer.MIN_VALUE;
        for(int e: array){
            if(e>max){
                max = e;
            }
        }
        System.out.println("\n\nthe value of the maximum element in this array is: "+ max);

        // SOLUTION 7: Write a Java program to find the minimum element in an array.
        int [] Arr = {1, 2100, 3, 455, 5, 34, 67};
        int min = Integer.MAX_VALUE;
        for(int e: Arr){
            if(e<min){
                min = e;
            }
        }
        System.out.println("\n\nthe value of the minimum element in this array is: "+ min);


        // SOLUTION 8: Write a Java program to find whether an array is sorted or not.
        boolean isSorted = true;
        int [] Array = {1, 12, 3, 4, 5, 34, 67};
        for(int i=0;i<Array.length-1;i++){
            if(arr[i] > Array[i+1]){
                isSorted = false;
                break;
            }
        }
        if(isSorted){
            System.out.println("The Array is sorted");
        }
        else{
            System.out.println("The Array is not sorted");
        }

        // SOLUTION 9: Write a Java Program to sort an array
        // Method 1:
        int[] my_arr = {64, 34, 25, 12, 22, 11, 90};

        // Outer loop for the number of passes
        for (int i = 0; i < my_arr.length - 1; i++) {

            // Inner loop for comparison and swapping
            for (int j = 0; j < my_arr.length - i - 1; j++) {
                if (my_arr[j] > my_arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp1 = my_arr[j];
                    my_arr[j] = my_arr[j + 1];
                    my_arr[j + 1] = temp1;
                }
            }
        }

        System.out.println("Sorted Array:");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        // Method 2: using the Array class:
        int[] numbers = {8, 2, 7, 3, 1, 5};

        // Sort the array using Arrays.sort() method
        Arrays.sort(numbers);

        // Print the sorted array
        System.out.println("\nSorted Array using Array class:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

}
