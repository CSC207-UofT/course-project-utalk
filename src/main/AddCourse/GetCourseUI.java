package AddCourse;

import java.util.ArrayList;
import java.util.Scanner;

public class GetCourseUI {
    public GetCourseUI() {
    }

    public String[] loaddata() {
        System.out.println("Please enter course code: \n");
        Scanner course_code = new Scanner(System.in);
        String code = course_code.nextLine();
        System.out.println("Please enter course description: \n");
        Scanner course_description = new Scanner(System.in);
        String info = course_description.nextLine();
        System.out.println("Please enter course start year: \n");
        Scanner course_start_year = new Scanner(System.in);
        String year = course_start_year.nextLine();
        return new String[]{code, info, year};
    }
    public void runaddcourse(String[] info_lst){
        AllcourseToUI help_create_course = new AllcourseToUI();
        if (help_create_course.add_course(info_lst[0], info_lst[1], info_lst[2])) {
            System.out.println("Course added successfully!");
        } else {
            System.out.println("Course cannot be added as you are not a faculty!");
        }
    }
    public void updatecourseinfo(String[] info_lst){
        AllcourseToUI help_create_course = new AllcourseToUI();
        if (help_create_course.update_course(info_lst[0], info_lst[1], info_lst[2])) {
            System.out.println("Course info updated successfully!");
        } else {
            System.out.println("Course info cannot be updated as you are not a faculty!");
        }

    }
}
