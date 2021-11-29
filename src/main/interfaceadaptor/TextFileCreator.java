package interfaceadaptor;

import java.io.File;
import java.io.IOException;
// code reference https://www.w3schools.com/java/java_files_create.asp
public class TextFileCreator {
    /** Create a new file according to file_path
     * @param file_path the file path
     */
    public void createTextFile(String file_path) {
        try {
            File file = new File(file_path);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred. Please try again");
            e.printStackTrace();
        }
    }
}
