package MultidimensionalArrays;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        int mouseRow = -1;
        int mouseCol = -1;

        fillMatrix(scanner, n, matrix);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }
        int cheeses = 0;
        String direction = scanner.nextLine();
        while (!direction.equals("end")) {
            matrix[mouseRow][mouseCol] = '-';
            switch (direction) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;

            }
            if (mouseRow < 0 || mouseRow >= matrix.length || mouseCol < 0 || mouseCol >= matrix.length) {
                System.out.println("Where is the mouse?");
                break;
            } else if (matrix[mouseRow][mouseCol] == 'c') {
                cheeses++;
            } else if (matrix[mouseRow][mouseCol] == 'B') {
                continue;
            }
            matrix[mouseRow][mouseCol] = 'M';

            direction = scanner.nextLine();

        }
        if (cheeses >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeses);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeses);

        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }

    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            String rowContent = scanner.nextLine();
            char[] rowSymbols = rowContent.toCharArray(); //масив от символи
            matrix[row] = rowSymbols;
        }
    }
}

