package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] names = input.split("\\s+");

        Consumer<String> printName = name -> System.out.println(name);

        //printName приема name и я отпечатва

        for(String name : names){
            printName.accept(name);

            /* начин 2
           Consumer<String[] > printArray = array -> {
                for(String name : array){
                    System.out.println(name);
                    //printArray приема масив от текстове и го отпечатва
                }
            } printArray.accept(names)
             */
        }
    }
}
