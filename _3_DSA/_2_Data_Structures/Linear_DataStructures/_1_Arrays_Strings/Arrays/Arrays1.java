
import java.util.Scanner;

public class Arrays1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // Problem 1: Take a matrix as an input and print its elements & then search a number in the matrix

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the no. of Columns: ");
        int cols = sc.nextInt();

        int[][] numbers = new int[rows][cols];

        //input
        System.out.println("\nEnter Matrix Elements: ");
        //rows
        for (int i = 0; i < rows; i++) {
            //columns
            for (int j = 0; j < cols; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nOutput Matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("\nEnter an element to search in the matrix: ");
        int x = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //compare with x
                if (numbers[i][j] == x) {
                    System.out.println("x found at location (" + i + ", " + j + ")");
                }
            }
        }



    
        
        // Problem 2: Print the spiral order matrix as output for a given matrix of numbers. 
        System.out.print("Enter the no. of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter the no. of columns: ");
        int m = sc.nextInt();

        int matrix[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nThe Spiral Order Matrix is : ");
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = m - 1;

        //To print spiral order matrix
        while (rowStart <= rowEnd && colStart <= colEnd) {
            //step1
            for (int col = colStart; col <= colEnd; col++) {
                System.out.print(matrix[rowStart][col] + " ");
            }
            rowStart++;

            //step2
            for (int row = rowStart; row <= rowEnd; row++) {
                System.out.print(matrix[row][colEnd] + " ");
            }
            colEnd--;

            //step3
            for (int col = colEnd; col >= colStart; col--) {
                System.out.print(matrix[rowEnd][col] + " ");
            }
            rowEnd--;

            //step4
            for (int row = rowEnd; row >= rowStart; row--) {
                System.out.print(matrix[row][colStart] + " ");
            }
            colStart++;

            System.out.println();
        }

        // Problem 3: For a given matrix of N x M, print its transpose.
        System.out.print("Enter the no. of rows: ");
        n = sc.nextInt();
        System.out.print("Enter the no. of columns: ");
        m = sc.nextInt();

        int matrix1[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("The transpose is : ");
        //To print transpose
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();

    }

}
