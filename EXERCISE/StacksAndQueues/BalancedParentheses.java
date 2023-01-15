package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //последната отворена трябва да съвпада с последната затворена
        String input = scanner.nextLine();
        boolean areBalanced = false; //дали скобите са балансирани -> true
        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        for (int index = 0; index <= input.length() - 1; index++) {
            char currentBracket = input.charAt(index);

            //проверка за отворена скоба
            if (currentBracket == '{' || currentBracket == '(' || currentBracket == '[') {
     openBracketsStack.push(currentBracket);
                //проверка за затворена скоба
            } else if (currentBracket == '}' || currentBracket == ')' || currentBracket == ']') {
                //дали последната отворена съвпада с текущата затворена
                if(openBracketsStack.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char lastOpen = openBracketsStack.pop();
                //проверка дали текущата затворена съвпада с последната отворена
                if (currentBracket == '}' && lastOpen == '{') {
                    areBalanced = true;
                } else if (currentBracket == ']' && lastOpen == '[') {
                    areBalanced = true;
                } else if (currentBracket == ')' && lastOpen == '(') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }
        //преминали през всички скоби
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}