package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String pathIn = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsLabResources\\input.txt";
        String outPath = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsLabResources\\06.SortLinesOutput.txt";

        Path input = Paths.get(pathIn);
        Path output = Paths.get(outPath);

        List<String> lines = Files.readAllLines(input)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        Files.write(output, lines);


    }
}
