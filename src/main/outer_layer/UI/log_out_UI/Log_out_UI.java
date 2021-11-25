package outer_layer.UI.log_out_UI;

import interface_adaptor.CsvList_Transfer;
import outer_layer.UI.MainUI;
import use_case.login_out.Log_in;
import use_case.login_out.Log_out;

import java.util.ArrayList;
import java.util.Scanner;

public class Log_out_UI {


    public static void log_out_ui(){
        ArrayList<ArrayList<String>> current_list = CsvList_Transfer.csv_to_list();
        System.out.println("please type in your username");
        Scanner sc = new Scanner(System.in);
        String current_username = sc.nextLine();
        if (!Log_out.contains_user(current_list, current_username)){
            System.out.println("This user name does not exist. please re-enter or type in '\\q' to quit to main menu ");
            String type_in = sc.nextLine();
            if (type_in.equals("\\q")){
                MainUI.register_signin_ui();
            }
            else if (Log_out.contains_user(current_list, type_in)){
                //yes this user exist.
                Log_out.log_out_user(type_in);
                System.out.println("================================================================================================================================");
                MainUI.register_signin_ui();
            }
            else{
                System.out.println("please don't try usernames that is not belongs to you.");
                MainUI.register_signin_ui();
            }
        }
        else{
            //yes this user exist.
            Log_out.log_out_user(current_username);
            System.out.println("================================================================================================================================");
            MainUI.register_signin_ui();
        }

    }
}
