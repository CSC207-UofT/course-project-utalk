package outerlayer.userinterface.registeruserinterface;

import entity.Student;
import interfaceadaptor.CsvListTransfer;
import outerlayer.userinterface.MainUI;
import usecase.UserRegister;
import usecase.javastorage.AllStudents;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RegisterUI {
    public static String file_path = "data_base.csv";
    static int ID = 0;
    public static void registerUi() {
        ID = ID + 1;
        ArrayList<ArrayList<String>> current_list = CsvListTransfer.csvToList();
        System.out.println("Please enter your new user name. or enter 'quit' to go back to main menu.");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        if (username.equals("quit")) {
            //quit to main menu
            MainUI.registerSigninUi();
        }
        // Now we want to check whether this username already exists or not.
        ArrayList<String> user_name_list = new ArrayList<>();
        for (ArrayList<String> item : current_list) {
            user_name_list.add(item.get(1));
        }

        if (user_name_list.contains(username)) {
            System.out.println("This user name already exist. Please sign in or change another username.");
            System.out.println("================================================================================================================================");
            registerUi();
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

                            UserRegister.registerUser(Integer.toString(randomID), username, password1, "student", "false");
                            System.out.println("You have successfully sign up as student \"" + username + "\"");
                            Student student = new Student(Integer.toString(randomID), username, password1);
                            AllStudents.StundetHashMap.put(username, student);
                            MainUI.registerSigninUi();
                            break;
                        }

                        case "2":
                        case "professor": {
                            int randomID = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
                            //This code does not check whether this ID existed before or not.

                            UserRegister.registerUser(Integer.toString(randomID), username, password1, "professor", "false");
                            System.out.println("You have successfully sign up as professor \"" + username + "\"");
                            MainUI.registerSigninUi();
                            break;

                        }
                        case "3":
                        case "faculty": {
                            int randomID = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
                            //This code does not check whether this ID existed before or not.

                            UserRegister.registerUser(Integer.toString(randomID), username, password1, "Faculty", "false");
                            System.out.println("You have successfully sign up as faculty \"" + username + "\"");
                            MainUI.registerSigninUi();
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
                RegisterUI.registerUi();
            }
        }

    }

}
