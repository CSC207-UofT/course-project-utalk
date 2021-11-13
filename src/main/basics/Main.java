package basics;

import AddCourse.Faculty;
import AddCourse.GetCourseUI;

public class Main {
// how to balance between duplicate code and single module?
    public static void main(String[] args) {
        Status.user = new Faculty("1", "2", "3");
        GetCourseUI.get_method();
    }
}
