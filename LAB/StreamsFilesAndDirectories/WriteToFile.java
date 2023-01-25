package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {

        String pathIn = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsLabResources\\input.txt";
        String pathOut = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsLabResources\\02.WriteToFileOutput.txt";

        Set<Character> forbiddenSymbols = new HashSet<>();
        Collections.addAll(forbiddenSymbols, '.', ',', '!', '?');

        try (FileInputStream in = new FileInputStream(pathIn);
             FileOutputStream out = new FileOutputStream(pathOut)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                char myByteAsChar = (char) oneByte;
                if(!forbiddenSymbols.contains(myByteAsChar)){
                    out.write(myByteAsChar);
                }
                oneByte = in.read();
            }
        } catch (IOException e) {

        }

    }
}
