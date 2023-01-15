package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt(); //брой на елементите, които трябва да добавя в стека
        int s = scanner.nextInt(); // брой на елементите за премахване
        int x = scanner.nextInt(); // числото,което трябва да проверя дали го има


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // добавяне -> n на брой пъти
        for(int count = 1; count <= n; count ++){
            stack.push(scanner.nextInt());
        }
        //премахване -> s на брой пъти
        for (int i = 1; i <= s ; i++) {
            stack.pop();

        }
        //проверка дали х го има в стека
        if(stack.contains(x)){
            System.out.println("true");
        }else{
            if(!stack.isEmpty()){
                System.out.println(Collections.min(stack));
            }else{
                System.out.println(0);
            }
        }

    }
}
