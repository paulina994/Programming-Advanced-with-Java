package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        String[] rowsCols = scanner.nextLine().split(" ");
        int row = Integer.parseInt(rowsCols[0]);
        int col = Integer.parseInt(rowsCols[1]);
        int wrongValue = matrix[row][col];

        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<int[]> indexes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    int validValue = getValidValue(matrix, i, j, wrongValue);
                    values.add(validValue);
                    indexes.add(new int [] {i,j});
                }
            }
        }
        for (int i = 0; i < values.size(); i++) {
            matrix[indexes.get(i)[0]][indexes.get(i)[1]] = values.get(i);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getValidValue(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;

        if (isBounds(row + 1, col, matrix) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isBounds(row - 1, col, matrix) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        if (isBounds(row, col + 1, matrix) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }

        if (isBounds(row, col - 1, matrix) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }


        return sum;
    }

    private static boolean isBounds(int r, int c, int[][] matrix) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}

