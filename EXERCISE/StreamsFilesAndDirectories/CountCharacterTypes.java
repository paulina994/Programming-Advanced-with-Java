package StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        int vowelsCount = 0;
        int punctCount = 0;
        int consonantsCount = 0;

        String path = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsExResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        for(String line : allLines){
            int sum =0;
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if(currentSymbol == ' '){
                    continue;
                }
                if(currentSymbol == 'a'|| currentSymbol == 'e'|| currentSymbol == 'i'|| currentSymbol == 'o'|| currentSymbol == 'u'){
                    vowelsCount ++;
                }else if(currentSymbol == '!'||currentSymbol == '?'||currentSymbol == '.'||currentSymbol == ','){
                    punctCount++;
                }else{
                    consonantsCount++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_task_4.txt"));
        writer.write("Vowels: "+vowelsCount);
        writer.newLine();
        writer.write("Other symbols: " +consonantsCount);
        writer.newLine();
        writer.write("Punctuation: "+punctCount);
        writer.close();
    }
}
