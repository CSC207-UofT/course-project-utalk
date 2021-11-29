package interfaceadaptor.boundaries;
import java.io.FileWriter;
import java.io.IOException;
// code reference https://www.w3schools.com/java/java_files_create.asp
public class WriteIntoTxtFile {
    /** Write content into txt file
     * @param content The content.
     * @param file_path the path of txt file.
     */
    public void writeIntoTxtFile(String content, String file_path) {
        try {
            FileWriter writer = new FileWriter(file_path);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}

