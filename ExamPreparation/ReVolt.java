package MultidimensionalArrays;

import java.util.Scanner;

public class ReVolt {
    public static int playerRow;
    public static int playerCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.toCharArray();

            if (matrixRow.contains("f")) {
                playerRow = row;
                playerCol = matrixRow.indexOf("f");
            }
        }
        while (commandsCount-- > 0) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                movePlayerUp(matrix);
            } else if (command.equals("down")) {

            } else if (command.equals("right")) {

            } else if (command.equals("left")) {

            }
        }


        print(matrix);
    }

    private static void movePlayerUp(char[][] matrix) {
        int nextRow = playerRow - 1;
        int nextCol = playerCol;
        if (isOutOfBounds(matrix, nextRow, nextCol)) {
            if (nextRow < 0 || nextRow >= matrix.length) {
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            } else {
                nextCol = nextRow < 0 ? matrix[nextRow].length - 1 : 0;
            }
        } else if (matrix[nextRow][nextCol] == 'T') {
            return;
        } else if (matrix[nextRow][nextCol] == 'B') {

        }
        matrix[playerRow][playerCol] = '-';
        matrix[nextRow][nextCol] = 'f';
        playerRow = nextRow;
        playerCol = nextCol;

    }

    private static boolean isOutOfBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix.length;

    }

    public static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
