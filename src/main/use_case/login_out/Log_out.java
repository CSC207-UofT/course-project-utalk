package use_case.login_out;

import com.sun.tools.javac.Main;
import interface_adaptor.CsvList_Transfer;
import outer_layer.UI.MainUI;

import java.util.ArrayList;

public class Log_out {

    public static boolean contains_user(ArrayList<ArrayList<String>> current_list, String username){
        //helper function
        //return whether this list contains this username
        if (current_list.size() == 0){
            return false;
        }
        for (int i = 0; i < current_list.size(); i += 1){
            if (current_list.get(i).get(1).equals(username)){
                //found this user.
                return true;
            }
        }
        return false;
    }




    public static void log_out_user(String username){
        ArrayList<ArrayList<String>> current_list = CsvList_Transfer.csv_to_list();
        if (! contains_user(current_list, username)){
            System.out.println("There is no such user. Please re-check your username or sign up first.");
            MainUI.register_signin_ui();
        }
        for (int i = 0; i < current_list.size(); i += 1){
            if (current_list.get(i).get(1).equals(username)){
                //we located this user.
                current_list.get(i).set(4, "false");
            }
        }
        CsvList_Transfer.list_to_csv(current_list);
        System.out.println("You have successfully logged out");
    }
}
