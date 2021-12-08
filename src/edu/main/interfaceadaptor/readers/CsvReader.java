package interfaceadaptor.readers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CsvReader {
    /**This is helper method. This function transfer from str to arraylist.
     * @param string the string with data
     * @param split_by divider
     * @return arraylist transferred from str
     */
    public static ArrayList<String> strToArraylist(String string, String split_by) {
        return new ArrayList<>(Arrays.asList(string.split(split_by)));
    }


    /** Transfer a csv file into readable List<List<String>>. Each sublist is a row from the csv file.
     * @param file_path  the data csv file
     * @return readable List<List<String>>
     */
    public static ArrayList<ArrayList<String>> readCsv(String file_path) {
        String line;
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            while ((line = br.readLine()) != null) {
                result.add(strToArraylist(line, ","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
