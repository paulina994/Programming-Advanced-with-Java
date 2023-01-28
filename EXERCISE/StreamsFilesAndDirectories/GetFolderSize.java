package StreamsFilesAndDirectories;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        //1,достъп до папката -> път
        //2.обхождаме всички файлове в папката -> всеки файл взимаме размера -> сумиране
        //3. печатаме общия размер на папката

        String path = "C:\\Users\\PC\\IdeaProjects\\untitled\\src\\04\\JavaAdvancedFilesAndStreamsExResources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles(); //масив с всички файлове в папката
        int folderSize = 0; //размер на папката
        if (allFiles != null) {
            for (File file : allFiles) {
                folderSize += file.length();
            }
        }
        System.out.println("Folder size: " + folderSize);
    }
}
