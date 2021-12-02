package outerlayer.userinterface;

import entity.Faculty;
import interfaceadaptor.CsvListTransfer;
import outerlayer.userinterface.facultyuserinterface.FacultyUI;
import outerlayer.userinterface.logoutuserinterface.LogoutUI;
import outerlayer.userinterface.registeruserinterface.RegisterUI;
import outerlayer.userinterface.studentprofessorinterface.StudentProfessorUI;
import usecase.deleteuser.UserDeleter;
import interfaceadaptor.loginlogout.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class MainUI {
    public static void main(String[] args) {
        //This is the header of the program.
        System.out.println("\n================================================================================================================================\nWelcome to U talk!\n\n");

        //put functions below.
        registerSigninUi();


    }




    public static void registerSigninUi() {
        //this is command UI function for register and sign in and different functions are adding.
        System.out.println("================================================================================================================================");
        System.out.println("What would you like to do next? \n 1: register \n 2: log in \n 3: log out \n 4: make actions \n 9: quit program. \n10: administrator privileges");
        Scanner scan = new Scanner(System.in);
        String enter = scan.nextLine();
        switch (enter) {
            case "1" -> {
                System.out.println("Please follow the orders to register");
                RegisterUI.registerUi();
                System.out.println("registered successfully");

            }
            case "2" -> {
                System.out.println("PLease follow the orders to log in.");
                Login.logIn();
                System.out.println("Which action you want to make? ");
            }
            case "3" -> {
                System.out.println("Please follow the orders to log out.");
                LogoutUI.logOutUi();

            }
            case "4" ->{
                if (Login.loggedInUser == null){
                    System.out.println("Please register first.");
                }
                if (Login.loggedInUser instanceof Faculty){
                    FacultyUI.facultyPage();
                } else{
                    StudentProfessorUI.StuProPage();
                }
            }
            case "9" -> {
                System.out.println("Are you sure you wish to quit? PLease type in 'yes' to quit.");
                Scanner c = new Scanner(System.in);
                String word = c.nextLine();
                if (word.equals("yes")) {
                    System.out.println("Quit program successfully");
                    System.exit(0);
                } else {
                    System.out.println("You did not quit the program.\n");
                    registerSigninUi();
                }

            }
            case "10" -> {
                System.out.println("Please enter developer password.");
                Scanner a = new Scanner(System.in);
                String password = a.nextLine();
                if ("qiao123".equals(password)) {
                    //The line below eliminates infinite loop warning. Please don't remove it.
                    //noinspection InfiniteLoopStatement
                    while (true) {
                        System.out.println(" administrator privileges: \n " +
                                        "1: check all users\n " +
                                        "2: delete whole database\n " +
                                "10: back to main menu");
                        Scanner b = new Scanner(System.in);
                        String number = b.nextLine();
                        switch (number) {
                            case "1" -> {
                                System.out.println("[id, username, password, type, status]");
                                for (ArrayList<String> item : CsvListTransfer.csvToList()) {System.out.println(item);}
                                System.out.println(" " +
                                                "================================================================================================================================ " +
                                        "");
                                System.out.println("What would you like to do next?");
                            }
                            case "2" -> {
                                System.out.println("Be careful! \nAre you sure you wish to delete the whole database? yes/no");
                                Scanner scc = new Scanner(System.in);
                                String result = scc.nextLine();
                                if (result.equals("yes")) {
                                    UserDeleter.deleteAllUser();
                                    System.out.println("As you wish.");
                                    System.out.println("Database deleted.");
                                    System.out.println("\n================================================================================================================================");
                                    System.out.println("What would you like to do next?");
                                } else {
                                    System.out.println("You did not delete the database");
                                    System.out.println("\n================================================================================================================================");
                                    System.out.println("What would you like to do next?");
                                }
                            }
                            case "10" -> {
                                System.out.println("\n================================================================================================================================");
                                registerSigninUi();

                            }
                            default -> {
                                System.out.println("This is not a valid input. please type in again.");
                                System.out.println("================================================================================================================================");

                            }
                        }
                    }
                } else {
                    System.out.println("Password Incorrect!");
                    System.out.println("Please don't retry if you are not a developer.\n\n");
                    registerSigninUi();
                }
            }
            default -> {
                System.out.println("please type in a valid number.\n");
                registerSigninUi();
            }
        }
    }
}
