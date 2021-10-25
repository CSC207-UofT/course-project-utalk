package AddCourse;

import java.util.Dictionary;

public class AllCourses {
    static Dictionary<String, CoursePage> linked_page;
    static void add_to_list(String course_name, CoursePage course_page){
        linked_page.put(course_name, course_page);
    }

}
