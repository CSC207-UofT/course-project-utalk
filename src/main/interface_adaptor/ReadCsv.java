package interface_adaptor;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCsv {
    public static ArrayList<String> str_to_arraylist(String string, String split_by) {
        //This is helper method.
        //This function transfer from str to arraylist.
        ArrayList<String> result = new ArrayList<>();
        for (String item : string.split(split_by)) {
            result.add(item);
        }
        return result;
    }

    public static ArrayList<ArrayList<String>> read_csv(String file_path) {
        //Transfer a csv file into readable List<List<String>>. Each sublist is a row from the csv file.
        String line = "";
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            while ((line = br.readLine()) != null) {
                result.add(str_to_arraylist(line, ","));
                //result.add(Collections.singletonList(line));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
