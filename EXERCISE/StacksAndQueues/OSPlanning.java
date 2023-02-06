package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Contains all the tasks in LIFO order
        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);

        int endTask = Integer.parseInt(scanner.nextLine());
        int task = tasks.peek();
        int thread = threads.peek();

        while (task != endTask) {
            if (thread >= task) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
            task = tasks.peek();
            thread = threads.peek();
        }
        System.out.println("Thread with value " + threads.peek() + " killed task " + endTask);
        String leftThreads = threads.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(leftThreads);
    }
}


