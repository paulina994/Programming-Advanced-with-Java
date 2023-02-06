package MultidimensionalArrays;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой редове = брой колони
        String[] commands = scanner.nextLine().split(",\\s+");
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        //find python
        //find all food
        int countFood = 0; //общо количество храна в полето
        int rowPython = 0;
        int colPython = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 's') {
                    rowPython = row;
                    colPython = col;
                } else if (currentElement == 'f') {
                    countFood++;
                }
            }
        }
        //moves
        int length = 1;// дължина на змията
        boolean isDead = false;
        for (String command : commands) {
            matrix[rowPython][colPython] = '*';
            switch (command) {
                case "left":
                    colPython--;
                    break;
                case "right":
                    colPython++;
                    break;
                case "up":
                    rowPython--;
                    break;
                case "down":
                    rowPython++;
                    break;
            }
            //след преместването дали сме излязли извън полето
            if (rowPython < 0 || rowPython >= n) {
                if (rowPython < 0) {
                    rowPython = n - 1;
                }
                if (rowPython >= n) {
                    rowPython = 0;
                }
            }

            if (colPython < 0 || colPython >= n) {
                if (colPython < 0) {
                    colPython = n - 1;
                }
                if (colPython >= n) {
                    colPython = 0;
                }
            }
            if (countFood == 0) {
                break;
            }
            //проверка къде сме отишли
            if (matrix[rowPython][colPython] == 'f') {
                length++;
                countFood--; //изяждаме храната и намаляме количеството храна в полето
            }
            if (matrix[rowPython][colPython] == 'e') {
                isDead = true;
                break;
            }
            matrix[rowPython][colPython] = 's';

        }
        //ако не съм умрял или не е свършила храна ->
        if(countFood == 0){
            System.out.printf("You win! Final python length is %d%n", length);
        }else if(isDead){
            System.out.println("You lose! Killed by an enemy!");
        }else if (countFood != 0 || isDead) {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }
    }
}
