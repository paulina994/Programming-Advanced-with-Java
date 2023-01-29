package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        /*//начин 1 без функционално програмиране
        System.out.println(Collections.min(numbers));*/

        //начин 2
        //лист -> отпечатваме минималното число
        Consumer<List<Integer>> printMinNumber = list -> System.out.println(Collections.min(list));
        //printMinNumber приема лист и отпечатва минималния елемент в листа
        printMinNumber.accept(numbers);
        
    }
}
