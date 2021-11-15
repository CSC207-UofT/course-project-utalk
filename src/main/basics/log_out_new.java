package basics;

import java.util.ArrayList;
import java.util.Scanner;

public class log_out_new {
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
        ArrayList<ArrayList<String>> current_list = register_new.csv_to_list();
        if (! contains_user(current_list, username)){
            System.out.println("There is no such user. Please re-check your username or sign up first.");
            commandUI_new.register_signin_ui();
        }
        for (int i = 0; i < current_list.size(); i += 1){
            if (current_list.get(i).get(1).equals(username)){
                //we located this user.
                current_list.get(i).set(4, "false");
            }
        }
        register_new.list_to_csv(current_list);
        System.out.println("You have successfully logged out");
    }


    public static void log_out_ui(){
        ArrayList<ArrayList<String>> current_list = register_new.csv_to_list();
        System.out.println("please type in your username");
        Scanner sc = new Scanner(System.in);
        String current_username = sc.nextLine();
        if (! contains_user(current_list, current_username)){
            System.out.println("This user name does not exist. please re-enter or type in '\\q' to quit to main menu ");
            String type_in = sc.nextLine();
            if (type_in.equals("\\q")){
                commandUI_new.register_signin_ui();
            }
            else if (contains_user(current_list, type_in)){
                //yes this user exist.
                log_out_user(type_in);
                System.out.println("================================================================================================================================");
                commandUI_new.register_signin_ui();
            }
            else{
                System.out.println("please don't try usernames that is not belongs to you.");
                commandUI_new.register_signin_ui();
            }
        }
        else{
            //yes this user exist.
            log_out_user(current_username);
            System.out.println("================================================================================================================================");
            commandUI_new.register_signin_ui();
        }

    }
}
