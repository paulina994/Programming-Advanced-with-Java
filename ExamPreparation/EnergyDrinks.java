package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> milligramsOfCaffein = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrink = new ArrayDeque<>();

        String input = scanner.nextLine();

        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(milligramsOfCaffein::push);

        input = scanner.nextLine();
        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(energyDrink::offer);
        int totalCaffein = 0;


        while (!milligramsOfCaffein.isEmpty() && !energyDrink.isEmpty()) {


            int milligram = milligramsOfCaffein.peek();
            int drink = energyDrink.peek();
            int caffeinInTheDrink = milligram * drink;

            if (totalCaffein + caffeinInTheDrink <= 300) {
                milligramsOfCaffein.pop();
                energyDrink.poll();
                totalCaffein += caffeinInTheDrink;
            } else if (caffeinInTheDrink + totalCaffein > 300) {
                milligramsOfCaffein.pop();
                energyDrink.poll();
                energyDrink.offer(drink);
                if (totalCaffein >= 30) {
                    totalCaffein -= 30;
                }
            }
        }
        if (!energyDrink.isEmpty()) {
            System.out.printf("Drinks left: %s%n", String.join(", ", Arrays.asList(energyDrink.toString().
                    substring(1, energyDrink.toString().length() - 1))));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffein);
    }
}
