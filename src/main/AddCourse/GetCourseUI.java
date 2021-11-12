package AddCourse;


import basics.Status;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class GetCourseUI {
    public GetCourseUI() {
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
                 Please enter 1 or 2""");
        String input_str = input_help.getinput(System.in).nextLine();
        while (!(input_str.equals("1")||input_str.equals("2"))){
            System.out.println("Please enter 1 or 2");
            input_str = input_help.getinput(System.in).nextLine();
        }
        CreateandUpdate createandUpdate = new CreateandUpdate();
        String[] args = GetCourseUI.loaddata();
        if (Objects.equals(input_str, "1")){
            createandUpdate.runaddcourse(args);
        } else{
            createandUpdate.updatecourseinfo(args);
        }
    }
}
