package StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        //words.txt -> думи, които ще броим в друг файл
        String pathWords = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsExResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        //дума -> бр. срещанията
        Map<String, Integer> countWords = new HashMap<>();
        //1. прочетем всички думи от файла и всяка една дума я съхраним в мап
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));
        for (String lineWithWords : allLinesWithWords) {
            Arrays.stream(lineWithWords.split("\\s+")).forEach(
                    word -> {
                        countWords.put(word, 0);

                    }
            );
        }
        String path = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsExResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        //обхождаме всеки един ред -> взимаме всички думи на всеки ред -> проверяваме дали думата трябва да я преброим(думите, които са в мап)
        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines)
            {
                Arrays.stream(line.split("\\s+")).forEach(word -> {
                    if (countWords.containsKey(word)) {
                        countWords.put(word, countWords.get(word) + 1);
                    }
                });
            }

        //3.принтираме резултата
        //сортираме по value
        PrintWriter writer = new PrintWriter("result.txt");
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
