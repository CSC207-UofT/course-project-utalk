package interfaceadaptor.loginlogout;

import entity.*;
import interfaceadaptor.readers.CsvReader;
import outerlayer.userinterface.MainUI;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static outerlayer.userinterface.FilePathHelper.FILEPATH;

public class Login {

    public static String file_path = FILEPATH + "/user.csv";
    public static String Current_username = "Please recheck log in process, you have not recorded username successfully";
    public static String Current_password = "Please recheck log in process, you have not recorded password successfully";
    public static String Current_id = "Does not exist yet";
    public static String currentType = "Does not exist yet";
    public static User loggedInUser = null;

    public static void logIn() {
        ArrayList<ArrayList<String>> current_file = CsvReader.readCsv(file_path);
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
                    String requiredPassword = user.get(2);
                    while (!(Objects.equals(requiredPassword, password))&&(!(Objects.equals(password, "q")))){
                        System.out.println("Please reenter your password.");
                        password = scan.nextLine();
                    }
                    if (Objects.equals(requiredPassword, password)){
                        Current_password = requiredPassword;
                        Current_id = user.get(0);
                        currentType = user.get(3);
                        if (Objects.equals(currentType, "student")){
                            loggedInUser = new Student(Current_id, Current_username, Current_password);
                        } else if  (Objects.equals(currentType, "professor")){
                            loggedInUser = new Professor(Current_id, Current_username, Current_password);
                        } else{
                            loggedInUser = new Faculty(Current_id, Current_username, Current_password);
                        }
                        System.out.println("logged in successfully");
                        MainUI.registerSigninUi();
                    } else{
                        MainUI.registerSigninUi();
                    }
                    }}


        } else {
            //This user has not registered before.
            System.out.println("You have not registered yet. Please register first.");
            MainUI.registerSigninUi();

        }


    }
}

