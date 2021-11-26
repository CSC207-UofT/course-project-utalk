package interface_adaptor.Presenter;
import entity.CoursePage;
import entity.Professor;
import use_case.JavaStorage.AllCourses;


import java.util.Map;

public class CoursePagePresenter {
    // properly present the course page, the main method takes the string of course as input
    public void CoursePresenter(String course) {
        CoursePage cour = AllCourses.coursePageHashMap.get(course);
        Map<String, Object> info_map = cour.course.courseInfoGetter();
        System.out.println("Course: " + info_map.get("code") + "\n" + "Year: " + info_map.get("year"));
        System.out.println("======================================================================\n");
        System.out.println("Professor(s): \n");
        for (Professor prof: cour.professor_list) {
            System.out.println(prof.getUserName() + ", ");
        }
        System.out.println("""

                Course Information:
                """);
        System.out.println(info_map.get("description") + "\n");
        System.out.println(cour.info_added);
    }
}
