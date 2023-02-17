package StackAndQueue;

import java.util.*;

public class AutumnCocktails {
    private static final int PEAR_SOUR = 150;
    private static final int THE_HARVEST = 250;
    private static final int APPLE_HINNY = 300;
    private static final int HIGH_FASHION = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);
        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (String token : tokens) {
            ingredients.offer(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        for (String token : tokens) {
            freshness.push(Integer.parseInt(token));
        }
        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int firstIngredient = ingredients.poll();
            if (firstIngredient == 0) {
                continue;
            }
            int lastFreshness = freshness.pop();

            int totalLevel = firstIngredient * lastFreshness;
            switch (totalLevel) {
                case PEAR_SOUR:
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    break;
                case THE_HARVEST:
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    break;
                case APPLE_HINNY:
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    break;
                case HIGH_FASHION:
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    break;
                default:
                    firstIngredient += 5;
                    ingredients.offer(firstIngredient);
                    break;

            }


        }
        if (cocktails.get("Pear Sour") > 0 && cocktails.get("Apple Hinny") > 0 && cocktails.get("The Harvest") > 0 && cocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            //останали съставки
            int sum = 0;
            //int leftOverIngredients = ingredients.stream().mapToInt(e -> e).sum();
            for (Integer ingredient : ingredients) {
                sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n",sum);
        }
        if (cocktails.get("Apple Hinny") > 0) {
            System.out.printf(" # Apple Hinny --> %d%n", cocktails.get("Apple Hinny"));
        }
        if (cocktails.get("High Fashion") > 0) {
            System.out.printf(" # High Fashion --> %d%n", cocktails.get("High Fashion"));
        }
        if (cocktails.get("Pear Sour") > 0) {
            System.out.printf(" # Pear Sour --> %d%n", cocktails.get("Pear Sour"));
        }
        if (cocktails.get("The Harvest") > 0) {
            System.out.printf(" # The Harvest --> %d%n", cocktails.get("The Harvest"));

        }
    }
}