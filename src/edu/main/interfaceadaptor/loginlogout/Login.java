package interfaceadaptor.loginlogout;

import entity.*;
import interfaceadaptor.readers.CsvReader;
import outerlayer.userinterface.MainUI;
import usecase.userfactory.UserFactory;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static outerlayer.userinterface.FilePathHelper.FILEPATH;

public class Login {

    public static String file_path = FILEPATH + "/user.csv";
    public static User loggedInUser = null;

    /**
     * the login in step which will ask the user to type in their username and the password. if both information matches
     * the user will login in with that account, if not we will ask user to check their username and password
     */
    public static void logIn() {
        ArrayList<ArrayList<String>> current_file = CsvReader.readCsv(file_path);
        System.out.println("What is your username?");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
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
                        String currId = user.get(0);
                        String currentType = user.get(3);
                        String[] input = new String[] {currId, username, password, currentType};
                        Login.loggedInUser = UserFactory.create(input);
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


