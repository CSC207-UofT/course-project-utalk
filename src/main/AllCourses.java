import java.util.Dictionary;
import java.util.HashMap;

public class AllCourses {
    public static HashMap<String, CoursePage> linked_page;
    public static void add_to_list(String course_name, CoursePage course_page){
        linked_page.put(course_name, course_page);
    }
//Should the key type not be course?
}
