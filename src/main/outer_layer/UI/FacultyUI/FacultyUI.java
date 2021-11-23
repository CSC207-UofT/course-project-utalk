package outer_layer.UI.FacultyUI;

import use_case.CreateandUpdate.CreateandUpdate;

import java.util.Objects;

public class FacultyUI {
    //TODO: put the relevant stuff here
    public FacultyUI() {
    }
    static final GetInputIn input_help = new GetInputIn();

    public static String[] loaddata() {
        System.out.println("Please enter course code: \n");
        String code = input_help.getinput(System.in).nextLine();
        System.out.println("Please enter course description: \n");
        String info = input_help.getinput(System.in).nextLine();
        System.out.println("Please enter course start year: \n");
        String year = input_help.getinput(System.in).nextLine();
        return new String[]{code, info, year};
    }
    public static void get_method(){
        System.out.println("""
            Choose which operation you want to make:\s
             1: add course 2: update course\s
             Please enter 1 or 2, enter quit to return to the main menu""");
        String input_str = input_help.getinput(System.in).nextLine();
        if (input_str.equals("quit")){
            // TODO: revise it after general UI has been revised
        }
        while (!(input_str.equals("1")||input_str.equals("2")||input_str.equals("quit"))){
            System.out.println("Please enter 1 or 2, or type quit to quit");
            input_str = input_help.getinput(System.in).nextLine();
        }
        if (Objects.equals(input_str, "quit")){
            // TODO: revise it after general UI has been revised
        }
        CreateandUpdate createandUpdate = new CreateandUpdate();
        String[] args = FacultyUI.loaddata();
        if (Objects.equals(input_str, "1")){
            createandUpdate.runaddcourse(args);
        } else {
            createandUpdate.updatecourseinfo(args);
        }
    }
}
