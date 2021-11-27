package use_case.login_out;

import entity.User;
import interface_adaptor.CsvList_Transfer;
import outer_layer.UI.MainUI;

import javax.swing.plaf.ColorUIResource;
import java.util.ArrayList;
import java.util.Scanner;

public class Log_in {

    public static String file_path = "data_base.csv";
    public static String Current_username = "Please recheck log in process, you have not recorded username successfully";
    public static String Current_password = "Please recheck log in process, you have not recorded password successfully";


    public static void log_in() {
        ArrayList<ArrayList<String>> current_file = CsvList_Transfer.csv_to_list();
        System.out.println("What is your username?");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        Current_username = username; // This line record username into static string.
        ArrayList<String> current_username = new ArrayList<>();
        for (ArrayList<String> user : current_file) {
            current_username.add(user.get(1));
        }
        if (current_username.contains(username)) {
            //this user has registered before.
            System.out.println("Please type in your password.");
            String password = scan.nextLine();
            for (ArrayList<String> user : current_file) {
                if (user.get(1).equals(username)) {
                    //we have found this user.
                    if (user.get(2).equals(password)) {
                        //password correct. change status.
                        ArrayList<ArrayList<String>> current_list = CsvList_Transfer.csv_to_list();
                        for (int i = 0; i < current_list.size(); i += 1) {
                            if (current_list.get(i).get(1).equals(user.get(1))) {
                                //found this person.
                                current_list.get(i).set(4, "true");
                            }
                        }
                        CsvList_Transfer.list_to_csv(current_list);
                        System.out.println("Log in successfully");
                        Current_password = password;// Password matched. Record this password.
                    } else {
                        //password incorrect
                        System.out.println("Sorry, password incorrect. Please type in password again or type '\\q' to go back to main menu.");
                        String password2 = scan.nextLine();
                        do {
                            System.out.println("Sorry, password incorrect. Please type in password again or type '\\q' to go back to main menu.");
                            password2 = scan.nextLine();
                        }
                        while ((!password2.equals(user.get(2))) && (!password2.equals("\\q")));
                        if (password2.equals("\\q")) {
                            MainUI.register_signin_ui();
                        } else if (password2.equals(user.get(2))) {
                            // password correct at last.
                            Current_password = password2;//Record this password into th csv file.
                            ArrayList<ArrayList<String>> current_list = CsvList_Transfer.csv_to_list();
                            for (int i = 0; i < current_list.size(); i += 1) {
                                if (current_list.get(i).get(1).equals(user.get(1))) {
                                    //found this person.
                                    current_list.get(i).set(4, "true");
                                }
                            }
                            //save this list to current file
                            CsvList_Transfer.list_to_csv(current_list);

                            System.out.println("Log in successfully");


                        }


                    }
                }
            }

        } else {
            //This user has not registered before.
            System.out.println("You have not registered yet. Please register first.");
            MainUI.register_signin_ui();

        }


    }
    public static User loggedin_user(){
        //This function will return the user who is currently logging in.
        User current_user = new User("No need identifier anymore", Current_username, Current_password);
        return current_user;
    }


}
