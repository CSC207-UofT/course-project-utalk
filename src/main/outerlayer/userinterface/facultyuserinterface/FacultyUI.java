package outerlayer.userinterface.facultyuserinterface;

import interfaceadaptor.contollers.Controller;
import outerlayer.userinterface.MainUI;

import java.util.Objects;

public class FacultyUI {
    public FacultyUI() {
    }
    static final InputGetter input_help = new InputGetter();

    public static String[] loadData() {
        System.out.println("Please enter course code: \n");
        String code = input_help.getInput(System.in).nextLine();
        System.out.println("Please enter course description: \n");
        String info = input_help.getInput(System.in).nextLine();
        System.out.println("Please enter course start year: \n");
        String year = input_help.getInput(System.in).nextLine();
        return new String[]{code, info, year};
    }
    public static void facultyPage(){
        System.out.println("""
                 Choose which operation you want to make:
                 1: add course 2: update course Please enter 1 or 2,\s
                enter quit to return to the main menu""");
        String input_str = input_help.getInput(System.in).nextLine();
        if (input_str.equals("quit")){
            MainUI.registerSigninUi();
        }
        while (!input_str.matches("[12]") && !input_str.equals("quit")){
            System.out.println("Please enter 1 or 2, or type quit to quit");
            input_str = input_help.getInput(System.in).nextLine();
        }
        Controller.control(input_str, FacultyUI.loadData());
        if (Objects.equals(input_str, "quit")) {
            MainUI.registerSigninUi();
        }
    }
}
