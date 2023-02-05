package MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n]; // квадратна матрица

        //1.напълваме матрицата
        fillMatrix(matrix, scanner);
        //2.намираме сумата от главния диагонал
        int sumPrimary = getSumPrimaryDiagonal(matrix);
        //3.намираме сумата от второстепенния диагонал
        int sumSecondary = getSumSecondaryDiagonal(matrix);
        //4. абс. стойност на разликата между сбора от диагоналите
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0; //сума от елементите на второстепенния диагонал
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (col == matrix.length - row - 1) {
                    sum += currentElement;
                }

            }
        }
        return sum;
    }

    private static int getSumPrimaryDiagonal(int[][] matrix) {
        //всички елементи -> сумираме само тези, които се намират на главния диагонал
        int sum = 0; //сума на елементите от главния диагонал
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (row == col) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
