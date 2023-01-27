package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsExResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;
       /* BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        //спираме: line = null
        while (line != null) {
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                sum += currentSymbol;
            }

                line = br.readLine();
            }
            System.out.println(sum);*/
        byte [] allBytes = Files.readAllBytes(Path.of(path));
        for(byte ascii : allBytes){
            if(ascii != 10 && ascii != 13)
            sum += ascii;
        }
        System.out.println(sum);
        //начин 2:
        /* long sum = 0;
        for(String line : allLines) {
        for (char symbol : line.toCharArray()) {
        sum+=symbol;
        }
        }
         System.out.println(sum)
         */

        }
    }
