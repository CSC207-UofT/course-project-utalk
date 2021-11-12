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
    public static void add_course(){
        String[] args = GetCourseUI.loaddata();
        CreateandUpdate createandUpdate = new CreateandUpdate();
        createandUpdate.runaddcourse(args);
    }

    public static void update_course(){
        String[] args = GetCourseUI.loaddata();
        CreateandUpdate createandUpdate = new CreateandUpdate();
        createandUpdate.updatecourseinfo(args);
    }
    public static void get_method(){
        System.out.println("Choose which operation you want to make: \n 1: add course 2: update course \n");
        String input_str = input_help.getinput(System.in).nextLine();
        if (Objects.equals(input_str, "1")){
            add_course();
        } else{
            update_course();
        }
    }
}
