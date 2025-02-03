
import java.util.Scanner;

public class Arrays {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        // Problem 1: Take an array of names as input from the user and print them on the screen.
        Scanner sc = new Scanner(System.in);

        int size;
        System.out.print("Enter the size of Array: ");
        size = sc.nextInt();

        String[] names = new String[size];

        //Input
        System.out.println("Enter names: ");
        for(int i=0; i<size;i++){
            names[i] = sc.next();
        }
        //Output
        System.out.print("\nNames are: ");
        for(String name: names){
            System.out.print(name+" ");
        }



        // Problem 2: Find the maximum & minimum number in an array of integers. 
        int numbers [] = {2,3,4,6,7,8,10};
        int number1 [] = {12,35,4,69,70,8,10};

        int res[] = findMinMax(numbers);
        System.out.printf("\nMin Element: %d | Max Element: %d",res[0],res[1]);

        int res1[] = findMinMax(number1);
        System.out.printf("\nMin Element: %d | Max Element: %d\n",res1[0],res1[1]);
        

        // Problem 3: Take an array of numbers as input and check if it is an array sorted in ascending order.
        int[] nums = {1, 2, 4, 7,69,70};  
        int[] nums1 = {30, 20, 16, 12, 10};  
        
        // Call the function to check and print if the array is sorted in ascending order
        checkSortedAscending(nums);
        checkSortedAscending(nums1);

        sc.close();

    }

    public static int[] findMinMax(int [] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<=nums.length-1;i++){
            if(nums[i]<min){
                min = nums[i];
            }else if(nums[i]>max){
                max = nums[i];
            }
        }
        return new int []{min,max};
    }


    public static void checkSortedAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) { //Condition for descending sorted array
                System.out.println("\nThe array is not sorted in ascending order.");
                return; // Exit the function early if it's not sorted
            }
        }
        System.out.println("\nThe array is sorted in ascending order.");
    }
}
