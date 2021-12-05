package interfaceadaptor.loginlogout;

import interfaceadaptor.gateways.CsvListTransfer;
import outerlayer.userinterface.MainUI;

import java.util.ArrayList;

public class Logout {

    public static boolean containsUser(ArrayList<ArrayList<String>> current_list, String username){
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




    public static void logOutUser(String username){
        ArrayList<ArrayList<String>> current_list = CsvListTransfer.csvToList();
        if (! containsUser(current_list, username)){
            System.out.println("There is no such user. Please re-check your username or sign up first.");
            MainUI.registerSigninUi();
        }
        for (int i = 0; i < current_list.size(); i += 1){
            if (current_list.get(i).get(1).equals(username)){
                //we located this user.
                current_list.get(i).set(4, "false");
            }
        }
        CsvListTransfer.listToCsv(current_list);
        System.out.println("You have successfully logged out");
    }
}
