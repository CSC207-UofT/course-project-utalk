package interfaceadaptor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class CsvReader {
    public static ArrayList<String> strToArraylist(String string, String split_by) {
        //This is helper method.
        //This function transfer from str to arraylist.
        ArrayList<String> result = new ArrayList<>();
        result.addAll(Arrays.asList(string.split(split_by)));
        return result;
    }
    public static ArrayList<ArrayList<String>> readCsv(String file_path) {
        //Transfer a csv file into readable List<List<String>>. Each sublist is a row from the csv file.
        String line = "";
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
