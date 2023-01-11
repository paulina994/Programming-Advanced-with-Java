package StackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        int steps = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> kids = new PriorityQueue<>();
        Collections.addAll(kids, names);

        int currentSteps = 0;
        while (kids.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String kid = kids.poll();
                kids.offer(kid);
                currentSteps++;

            }
            if (isPrime(currentSteps)) {
                System.out.println("Prime " + kids.peek() );

            } else {
                String removedChild = kids.poll();
                System.out.println("Removed " + removedChild);
            }
        }
        System.out.println("Last is " + kids.poll());
    }

    private static boolean isPrime(int currentSteps) {
        if (currentSteps == 1){
            return false;
        }
            for (int i = 2; i < currentSteps; i++) {
                if (currentSteps % i == 0) {
                    return false;
                }
            }
        return true;
    }
}
