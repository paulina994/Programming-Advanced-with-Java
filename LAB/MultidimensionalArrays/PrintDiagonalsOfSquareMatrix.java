package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowData;

        }
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");

        }
        System.out.println();

        for (int col= 0; col < n; col++) {
            System.out.print(matrix[n - 1 - col][col] + " ");
        }
    }
}
