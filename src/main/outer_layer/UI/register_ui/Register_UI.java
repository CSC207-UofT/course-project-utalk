package outer_layer.UI.register_ui;

import com.sun.tools.javac.Main;
import interface_adaptor.CsvList_Transfer;
import outer_layer.UI.MainUI;
import use_case.Register_user;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Register_UI {
    public static String file_path = "data_base.csv";
    static int ID = 0;
    public static void register_ui() {
        ID = ID + 1;
        ArrayList<ArrayList<String>> current_list = CsvList_Transfer.csv_to_list();
        System.out.println("Please enter your new user name. or enter 'quit' to go back to main menu.");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        if (username.equals("quit")) {
            //quit to main menu
            MainUI.register_signin_ui();
        }
        // Now we want to check whether this username already exists or not.
        ArrayList<String> user_name_list = new ArrayList<>();
        for (ArrayList<String> item : current_list) {
            user_name_list.add(item.get(1));
        }

        if (user_name_list.contains(username)) {
            System.out.println("This user name already exist. Please sign in or change another username.");
            System.out.println("================================================================================================================================");
            register_ui();
        } else {
            //Valid username. Now ask for password.
            System.out.println("Please enter password.");
            String password1 = scan.nextLine();
            System.out.println("Please re-enter password");
            String password2 = scan.nextLine();
            if (password1.equals(password2)) {
                while (true) {
                    System.out.println("What is your identity?");
                    System.out.println("1: student. 2: professor. 3: faculty");
                    Scanner sc = new Scanner(System.in);
                    String type = sc.nextLine();
                    switch (type) {
                        case "1":
                        case "student": {
                            int randomID = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);

                            //This code does not check whether this ID existed before or not.

                            Register_user.register_user(Integer.toString(randomID), username, password1, "student", "false");
                            System.out.println("You have successfully sign up as student \"" + username + "\"");
                            MainUI.register_signin_ui();
                            break;
                        }

                        case "2":
                        case "professor": {
                            int randomID = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
                            //This code does not check whether this ID existed before or not.

                            Register_user.register_user(Integer.toString(randomID), username, password1, "professor", "false");
                            System.out.println("You have successfully sign up as professor \"" + username + "\"");
                            MainUI.register_signin_ui();
                            break;

                        }
                        case "3":
                        case "faculty": {
                            int randomID = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
                            //This code does not check whether this ID existed before or not.

                            Register_user.register_user(Integer.toString(randomID), username, password1, "Faculty", "false");
                            System.out.println("You have successfully sign up as faculty \"" + username + "\"");
                            MainUI.register_signin_ui();
                            break;

                        }
                        default: {
                            System.out.println("this is not a valid input. please re-enter.");
                            System.out.println("\n================================================================================================================================");
                        }
                    }
                }
            } else {
                System.out.println("You have entered different password. Request denied.");
                System.out.println("================================================================================================================================");
                Register_UI.register_ui();
            }
        }

    }

}
