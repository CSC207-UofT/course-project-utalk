package AddCourse;

import java.util.Scanner;

public class GetCourseUI {
    public GetCourseUI() {
    }

    public void runaddcourse() {
        AllcourseToUI help_create_course = new AllcourseToUI();
        System.out.println("Please enter course code: \n");
        Scanner course_code = new Scanner(System.in);
        String code = course_code.nextLine();
        System.out.println("Please enter course description: \n");
        Scanner course_description = new Scanner(System.in);
        String info = course_description.nextLine();
        System.out.println("Please enter course start year: \n");
        Scanner course_start_year = new Scanner(System.in);
        String year = course_start_year.nextLine();
        if (help_create_course.add_course(code, info, year)) {
            System.out.println("basics.Course added successfully!");
        } else {
            System.out.println("basics.Course cannot be added as you are not a faculty!");
        }

    }
}
