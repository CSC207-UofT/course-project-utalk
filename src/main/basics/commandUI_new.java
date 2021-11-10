package basics;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class commandUI_new {
    public static void main(String[] args) {
        //This is the header of the program.
        System.out.println("\n================================================================\nWelcome to U talk!\n\n" +
                "================================================================");

        //put functions below.
        register_signin_ui();

    }






    //developer password is Qiao123456
    public static void register_signin_ui(){
        //this is command UI function for register and sign in.
        System.out.println("What would you like to do next? \n 1: register \n 2: login \n 9: quit program. \n10: administrator privileges");
        Scanner scan = new Scanner(System.in);
        String enter = scan.nextLine();
        switch (enter) {
            case "1" -> System.out.println("Please follow the orders to register (wait for me debugging this function)");
            case "2" -> System.out.println("PLease follow the orders to log in (wait for me debugging this function)");
            case "9" -> {
                System.out.println("Are you sure you wish to quit? PLease type in 'yes' to quit.");
                Scanner c = new Scanner(System.in);
                String word = c.nextLine();
                if (word.equals("yes")){
                    System.out.println("Quit program successfully");
                    System.exit(0);
                }
                else {
                    System.out.println("You did not quit the program.\n");
                    register_signin_ui();
                }

            }
            case "10"-> {
                System.out.println("Please enter developer password.");
                Scanner a = new Scanner(System.in);
                String password = a.nextLine();
                if ("Qiao123456".equals(password)) {
                    //The line below eliminates infinite loop warning. Please don't remove it.
                    //noinspection InfiniteLoopStatement
                    while(true) {
                        System.out.println("""
                                administrator privileges:\s
                                 1: check all users\s
                                 2: delete whole database\s
                                 10: back to main menu""");
                        Scanner b = new Scanner(System.in);
                        String number = b.nextLine();
                        switch (number) {
                            case "1" -> {
                                System.out.println("already checked all users");
                            }
                            case "2" ->{
                                System.out.println("No! Don't do this! (This function is not written yet.)");
                            }
                            case "10" -> {
                                System.out.println("\n================================================================");
                                register_signin_ui();
                            }
                            default -> {
                                System.out.println("This is not a valid number. please type in again.");
                            }
                        }
                    }
                } else {
                    System.out.println("Password Incorrect!");
                    System.out.println("Please don't retry if you are not a developer.\n\n");
                    register_signin_ui();
                }
            }
            default -> {
                System.out.println("please type in a valid number.\n");
                register_signin_ui();
            }
        }
    }


}
