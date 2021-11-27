package interface_adaptor;

import use_case.Register_user;
import use_case.delete_user.DeleteUser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvList_Transfer {
    /*
    NOTE!!!
    Please do not use this class to save file and get file from database.
    Please user ReadCsv and WritetoCSV instead.
    I have renewed the functions there.
     */

    public static String file_path = "data_base.csv";


    public static ArrayList<String> str_to_arraylist(String string, String split_by) {
        //This is helper method.
        //This function transfer from str to arraylist.
        ArrayList<String> result = new ArrayList<>();
        for (String item : string.split(split_by)) {
            result.add(item);
        }
        return result;
    }


    public static ArrayList<ArrayList<String>> csv_to_list() {
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

    public static void list_to_csv(ArrayList<ArrayList<String>> list) {
        /*
        This function will renew the database file by that List<List<String>>.
         */
        DeleteUser.delete_all_user();
        int i = 0;
        if (list == null || list.size() == 0) {
            System.out.println("This list is empty or null.");
        } else {
            while (i < list.size()) {
                Register_user.register_user(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3), list.get(i).get(4));
                i += 1;
            }
        }


    }
}
