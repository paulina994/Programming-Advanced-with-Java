package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //добавяме 1 към всеки ел на списъка: приема списък -> връща списък с модифицирани елементи
        Function<List<Integer>, List<Integer>> addCommand = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiplyCommand = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        //умножаваме всеки един от елементите по 2: приемаме списък -> връщаме списък с модифицирани елементи


        Function<List<Integer>, List<Integer>> subtractCommand = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        //изваждаме 1 от всеки елемент на списъка: приема списък -> връщаме списък с модифицирани елементи

        Consumer<List<Integer>> printCommand = list -> list.forEach(number -> System.out.print(number + " "));
        //принтира всички елементи на списъка на нов ред: приема списък -> печатаме всеки елемент
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = addCommand.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyCommand.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractCommand.apply(numbers);
                    break;
                case "print":
                    printCommand.accept(numbers);
                    System.out.println();
                    break;

            }


            command = scanner.nextLine();
        }
    }
}
