package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsExResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

       //1.прочитаме файла
        //2,обхождаме всеки ред -> правим всички букви главни -> записваме реда в нов файл
        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            line.toUpperCase();
            bw.write(line.toUpperCase());
            bw.newLine();

        }
        bw.close();
/*        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();
            line = reader.readLine();
        }
        reader.close();
    }
}*/
    }}