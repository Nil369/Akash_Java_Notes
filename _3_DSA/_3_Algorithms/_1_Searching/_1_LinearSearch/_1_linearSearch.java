public class _1_linearSearch {

    public static void main(String[] args) {
        int[] nums = {23, 45, 1, 2, 8, 19, -3, 16, -11, 28};
        int target = 19;

        int ans = linearSearch(nums, target);
        int ans1 = linearSearch2(nums, target);
        boolean ans2 = linearSearch3(nums, target);

        System.out.println(target+" was found at index: "+ans);
        System.out.println(ans1+" was found");
        System.out.println(ans2);
    }

    // search in the array: return the index if item found
    // otherwise if item not found return -1
    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        // run a for loop
        for (int i = 0; i < arr.length; i++) {
            // check for element at every i if it is = target
            int element = arr[i];
            if (element == target) {
                return i;
            }
        }
        // this line will execute if none of the return statements above have executed
        // hence the target not found
        return -1;
    }

    static int linearSearch2(int []arr, int target){
        if (arr.length == 0) {
            return -1;
        }

        // run an enhanced for loop
        for (int element : arr) {
            if (element == target) {
                return element;
            }
        }
        
        return Integer.MAX_VALUE;
    }

    static boolean linearSearch3(int []arr, int target){
        if(arr.length==0) return false;

        for(int elem:arr) 
            if(elem==target)
                return true;

        return false;
    }
    
}
