package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //последната отворена трябва да съвпада с последната затворена
        String input = scanner.nextLine();
        boolean areBalanced = false; //дали скобите са балансирани -> true

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        ArrayDeque<Character> closedBracketsQueue = new ArrayDeque<>();
        for (int index = 0; index <= input.length() - 1; index++) {
            char currentBracket = input.charAt(index);

            //проверка за отворена скоба
            if (currentBracket == '{' || currentBracket == '(' || currentBracket == '[') {
                openBracketsStack.push(currentBracket);
                //проверка за затворена скоба
            } else if (currentBracket == '}' || currentBracket == ')' || currentBracket == ']') {
                //дали последната отворена съвпада с текущата затворена
                closedBracketsQueue.offer(currentBracket);
            }
        }
        if (openBracketsStack.size() != closedBracketsQueue.size()) {
            System.out.println("NO");
        } else {
            while (!openBracketsStack.isEmpty() && !closedBracketsQueue.isEmpty()) {
                char lastOpen = openBracketsStack.pop();
                char firstClosed = closedBracketsQueue.poll();
                if (firstClosed == '}' && lastOpen == '{') {
                    areBalanced = true;
                } else if (firstClosed == ']' && lastOpen == '[') {
                    areBalanced = true;
                } else if (firstClosed == ')' && lastOpen == '(') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }

            }
            if (areBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}


