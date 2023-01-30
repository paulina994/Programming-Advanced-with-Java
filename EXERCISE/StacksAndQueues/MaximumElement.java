package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();

            if (input.contains("1")) {
                String[] data = input.split(" ");
                int element = Integer.parseInt(data[1]);
                stack.push(element);

            } else if (input.contains("2")) {
                stack.pop();
            } else if (input.contains("3")) {
                if (stack.size() > 0) {
                    System.out.println(Collections.max(stack));
                }

            }
        }
    }


}
       /* Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= number; i++) {
            String input = scanner.nextLine();
            if (input.equals("2")) {
                stack.pop();
            } else if (input.equals("3")) {
                if (stack.size() > 0) {
                    System.out.println(Collections.max(stack));
                }

            } else {
                String[] data = input.split(" ");
                int element = Integer.parseInt(data[1]);
                stack.push(element);
            }
        }

    }
}*/
