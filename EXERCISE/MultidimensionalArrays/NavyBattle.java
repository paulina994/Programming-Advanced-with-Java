package MultidimensionalArrays;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());// размер на бойното поле, бр. на редове , бр. на колоните

        String[][] matrix = new String[n][n]; // бойно поле

        //1. пълним матрицата (бойно поле)
        fillMatrix(matrix, scanner);

        //къде се намира подводницата на бойното поле
        int submarineRow = -1; //текущ ред на подводницата
        int submarineCol = -1; //текуща колона на подводницата
        int countHits = 0; //брой на пътите , в които е уцелена подводницата
        int countCruiser = 0; //брой на потопени круизни кораби

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        while (true) {
            matrix[submarineRow][submarineCol] = "-";
             if (command.equals("up")) {
                submarineRow--;
            } else if (command.equals("down")) {
                submarineRow++;
            } else if (command.equals("left")) {
                submarineCol--;
            } else if (command.equals("right")) {
                submarineCol++;
            }
            //имаме новата позиция на подводницата
            String submarinePosition = matrix[submarineRow][submarineCol]; // на кое място се е преместила подводницата

            if (submarinePosition.equals("-")) {
                matrix[submarineRow][submarineCol] = "S";
            } else if (submarinePosition.equals("*")) {
                matrix[submarineRow][submarineCol] = "S";
                countHits++;

                if (countHits == 3) {
                    //подводницата е унищожена
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                    break;
                }
            }else if(submarinePosition.equals("C")){
                matrix[submarineRow][submarineCol] = "S";
                countCruiser++; // потапяме круизен кораб
                if(countCruiser ==3){
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }

            command = scanner.nextLine();
        }
//приключва битката -> принтираме бойното поле
        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1" , "2", "3"]
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
