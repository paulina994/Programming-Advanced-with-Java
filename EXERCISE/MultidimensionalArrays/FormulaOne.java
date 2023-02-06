package MultidimensionalArrays;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine()); //бр на редове и бр на колони
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][countCommands];

        fillMatrix(scanner, size, matrix);

        int newRow = 0;
        int newCol = 0;
        //P- позиция на играча
        //F - финала
        //B - бонус
        //T - капан
        int rowPlayer = 0;
        int colPlayer = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 'P') {
                    rowPlayer = row;
                    colPlayer = col;
                    break;
                }
            }
        }
        boolean hasWon = false;
        for (int commandCount = 1; commandCount <= countCommands; commandCount++) {
            String direction = scanner.nextLine();

            switch (direction) {
                case "up":
                    //row--;
                    newRow = checkIsOutside(rowPlayer - 1,size); //TODO: ПРОВЕРКА ДАЛИ РЕДЪТ Е В МАТРИЦАТА
                    newCol = checkIsOutside(colPlayer,size); // TODO: ПРОВЕРКА ДАЛИ КОЛОНАТА Е В МАТРИЦАТА
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer - 2,size);
                        newCol = checkIsOutside(colPlayer,size);
                    }
                    break;
                case "down":
                    newRow = checkIsOutside(rowPlayer + 1,size);
                    newCol = checkIsOutside(colPlayer, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer + 2,size);
                        newCol = checkIsOutside(colPlayer,size);
                    }
                    //row++;
                    break;
                case "left":
                    newRow = checkIsOutside(rowPlayer,size);
                    newCol = checkIsOutside(colPlayer - 1,size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer,size);
                        newCol = checkIsOutside(colPlayer - 2,size);
                    }
                    //col--;
                    break;
                case "right":
                    newRow = checkIsOutside(rowPlayer,size);
                    newCol = checkIsOutside(colPlayer + 1,size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer,size);
                        newCol = checkIsOutside(colPlayer + 2,size);
                    }
                    //col++;
                    break;

            }


            if (matrix[newRow][newCol] == 'T') {
                //нямаме преместване
                newRow = rowPlayer;
                newCol = colPlayer;
            } else {
                if (matrix[newRow][newCol] == 'F') {
                    hasWon = true;
                }
                //имаме преместване
                matrix[rowPlayer][colPlayer] = '.';
                matrix[newRow][newCol] = 'P';
                rowPlayer = newRow;
                colPlayer = newCol;

            }
        }
        if (hasWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static int checkIsOutside(int value,int size) {
        //ако е вътре в матрицата -> връщам стойността
        //ако е извън -> връщаме новата стойност
        if (value < 0) {
            value = size -1;
        }else if(value >= size){
            value = 0;
        }
        return value;
    }


    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();


        }
    }
}
