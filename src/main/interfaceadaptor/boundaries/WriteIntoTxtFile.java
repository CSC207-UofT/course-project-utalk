package interfaceadaptor.boundaries;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// code reference https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
public class WriteIntoTxtFile {
    /** Write content into txt file
     * @param content The content.
     * @param file_path the path of txt file.
     */
    public void writeIntoTxtFile(String content, String file_path) {
        try(FileWriter fileWriter = new FileWriter(file_path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter out = new PrintWriter(bufferedWriter))
        {
            out.println(content);
        } catch (IOException e) {
            System.out.print("Error occurs.");
        }
    }
}

