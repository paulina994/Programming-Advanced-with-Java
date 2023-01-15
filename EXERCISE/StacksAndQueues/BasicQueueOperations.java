package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt(); //брой на елементите, които трябва да добавя в стека
        int s = scanner.nextInt(); // брой на числата за премахване
        int x = scanner.nextInt(); // числото,което трябва да проверя дали го има


        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // добавяне -> n на брой пъти
        for(int count = 1; count <= n; count ++){
            queue.offer(scanner.nextInt());
        }
        //премахване -> s на брой пъти
        for (int i = 1; i <= s ; i++) {
            queue.poll();

        }
        //проверка дали х го има в стека
        if(queue.contains(x)){
            System.out.println("true");
        }else{
            if(!queue.isEmpty()){
                System.out.println(Collections.min(queue));
            }else{
                System.out.println(0);
            }
        }

    }
}
