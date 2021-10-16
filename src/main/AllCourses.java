import java.util.ArrayList;
import java.util.Dictionary;

public class AllCourses {
    static Dictionary<Course, CoursePage> linked_page;
    void add_to_list(Course course, CoursePage course_page){
        linked_page.put(course, course_page);
    }
}
