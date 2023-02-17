package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tulipsInput = scanner.nextLine();
        String daffodilsInput = scanner.nextLine();
        //лалетата -> стек
        // нарциси -> опашка
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
//пълним стека с лалета
        Arrays.stream(tulipsInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tulips::push);
        //пълним опашката с нарциси
        Arrays.stream(daffodilsInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(daffodils::offer);

        int bouquets = 0; // брой на букети
        int leftFlowers = 0; //цветята, които не са направени на букет
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int tulip = tulips.peek();
            int daffodil = daffodils.peek();
            int sum = tulip + daffodil;
            if (sum == 15) {
                //правя букет
                bouquets++;
                tulips.pop();
                daffodils.poll();
            } else if (sum > 15) {

                tulips.push(tulip - 2);
            } else if (sum < 15) {
                //съхраняваме сумата за по-късно
                leftFlowers += sum;
                tulips.pop();
                daffodils.poll();
            }
        }
        //брой на букетите
        //брой на цветята, които не са образували букет
        int bouquetsLeftFlowers = leftFlowers / 15;
        bouquets += bouquetsLeftFlowers;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.",(5- bouquets));
        }
    }
}
