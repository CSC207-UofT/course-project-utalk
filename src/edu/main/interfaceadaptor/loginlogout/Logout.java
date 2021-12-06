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
        for (ArrayList<String> strings : current_list) {
            if (strings.get(1).equals(username)) {
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
        for (ArrayList<String> strings : current_list) {
            if (strings.get(1).equals(username)) {
                //we located this user.
                strings.set(4, "false");
            }
        }
        CsvListTransfer.listToCsv(current_list);
        Login.loggedInUser = null;
        Login.Current_username = null;
        Login.Current_password = null;
        Login.Current_id = null;
        Login.currentType = null;
        System.out.println("You have successfully logged out");
    }
}
