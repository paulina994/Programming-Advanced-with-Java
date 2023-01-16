package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseWithSteck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //всички числа да ги сложим в стек
        //повтаряме: вадим число от стека -> докато стекът е пълен

        String input = scanner.nextLine();
        String[] inputNumbers = input.split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String number : inputNumbers){
            stack.push(number);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

}
