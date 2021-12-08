package outerlayer.userinterface.facultyuserinterface;

import interfaceadaptor.boundaries.DatabaseWriter;
import interfaceadaptor.contollers.Controller;
import outerlayer.userinterface.MainUI;

import java.util.Objects;

public class FacultyUI {
    public FacultyUI() {
    }
    static final InputGetter input_help = new InputGetter();

    /**Base on the input data update the course
     * @return the string[] with the course code, course information and the year.
     */
    public static String[] loadData() {
        System.out.println("\nPlease enter course code: ");
        String code = input_help.getInput(System.in).nextLine();
        System.out.println("\nPlease enter course description: ");
        String info = input_help.getInput(System.in).nextLine();
        System.out.println("\nPlease enter course start year: ");
        String year = input_help.getInput(System.in).nextLine();
        return new String[]{code, info, year};
    }


    /**
     * the user interface for the faculty
     */
    public static void facultyPage(){
        System.out.println("""
                 \nChoose which operation you want to make:
                1: add course 
                2: update course 
                Please enter 1 or 2
                Or enter quit to return to the main menu""");
        String input_str = input_help.getInput(System.in).nextLine();
        if (input_str.equals("quit")){
            DatabaseWriter.writeAll();
            MainUI.registerSigninUi();
        }
        while (!input_str.matches("[12]") && !input_str.equals("quit")){
            System.out.println("\nPlease enter 1 or 2, or type quit to quit");
            input_str = input_help.getInput(System.in).nextLine();
        }
        Controller.control(input_str, FacultyUI.loadData());
        FacultyUI.facultyPage();
        if (Objects.equals(input_str, "quit")) {
            DatabaseWriter.writeAll();
            MainUI.registerSigninUi();
        }
    }
}
