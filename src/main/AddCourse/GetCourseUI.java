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
}
