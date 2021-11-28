package outerlayer.userinterface.logoutuserinterface;

import interfaceadaptor.CsvListTransfer;
import outerlayer.userinterface.MainUI;
import interfaceadaptor.loginlogout.Logout;

import java.util.ArrayList;
import java.util.Scanner;

public class LogoutUI {


    public static void logOutUi(){
        ArrayList<ArrayList<String>> current_list = CsvListTransfer.csvToList();
        System.out.println("please type in your username");
        Scanner sc = new Scanner(System.in);
        String current_username = sc.nextLine();
        if (!Logout.containsUser(current_list, current_username)){
            System.out.println("This user name does not exist. please re-enter or type in '\\q' to quit to main menu ");
            String type_in = sc.nextLine();
            if (type_in.equals("\\q")){
                MainUI.registerSigninUi();
            }
            else if (Logout.containsUser(current_list, type_in)){
                //yes this user exist.
                Logout.logOutUser(type_in);
                System.out.println("================================================================================================================================");
                MainUI.registerSigninUi();
            }
            else{
                System.out.println("please don't try usernames that is not belongs to you.");
                MainUI.registerSigninUi();
            }
        }
        else{
            //yes this user exist.
            Logout.logOutUser(current_username);
            System.out.println("================================================================================================================================");
            MainUI.registerSigninUi();
        }

    }
}
