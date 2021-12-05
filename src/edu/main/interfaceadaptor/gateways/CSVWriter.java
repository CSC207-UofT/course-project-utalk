package interfaceadaptor.gateways;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {

   public static void write_to_csv(ArrayList<ArrayList<String>> list, String file_path){
        String need = List_to_string(list);
        try {
            FileWriter myWriter = new FileWriter(file_path);
            myWriter.write(need);
            myWriter.close();
            System.out.println("recorded successfully");
        }
        catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static String List_to_string(ArrayList<ArrayList<String>> need_to_convert){
        //This is a helper method that convert an arraylist of arraylist of String into string,
        String result = "";
        for (ArrayList<String>row : need_to_convert){
            for(String item : row){
                result = result.concat(item);
                result = result.concat(",");
            }
            int length = Math.max(result.length() - 1, 0);
            result = result.substring(0, length);
            result = result.concat("\n");
        }
        System.out.println(result);
        return result;
    }


}
