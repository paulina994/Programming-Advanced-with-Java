package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractInteger {
    public static void main(String[] args) throws FileNotFoundException {
        String inPath = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsLabResources\\input.txt";
        String outPath = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsLabResources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(inPath));
        PrintStream myFileOutput = new PrintStream(new FileOutputStream(outPath));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int myNumber = scanner.nextInt();
                //System.out.println(scanner.nextInt());
                myFileOutput.println(myNumber);
            }
            scanner.next();
        }

        myFileOutput.close();
    }
}
