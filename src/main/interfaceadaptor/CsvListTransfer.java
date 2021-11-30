package interfaceadaptor;

import usecase.UserRegister;
import usecase.deleteuser.UserDeleter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CsvListTransfer {
    /*
    NOTE!!!
    Please do not use this class to save file and get file from database.
    Please user ReadCsv and WritetoCSV instead.
    I have renewed the functions there.
     */

    public static String file_path = "data_base.csv";

    public static ArrayList<String> strToArraylist(String string, String split_by) {
        //This is helper method.
        //This function transfer from str to arraylist.
        ArrayList<String> result = new ArrayList<>();
        Collections.addAll(result, string.split(","));
        return result;
    }

    public static void listToCsv(ArrayList<ArrayList<String>> list) {
        /*
        This function will renew the database file by that List<List<String>>.
         */
        UserDeleter.deleteAllUser();
        int i = 0;
        if (list == null || list.size() == 0) {
            System.out.println("This list is empty or null.");
        } else {
            while (i < list.size()) {
                UserRegister.registerUser(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3), list.get(i).get(4));
                i += 1;
            }
        }
    }

    public static ArrayList<ArrayList<String>> csvToList() {
        //Transfer a csv file into readable List<List<String>>. Each sublist is a row from the csv file.
        String line = "";
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            while ((line = br.readLine()) != null) {
                result.add(strToArraylist(line, ","));
                //result.add(Collections.singletonList(line));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}