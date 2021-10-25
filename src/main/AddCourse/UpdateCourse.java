package AddCourse;


import java.util.Map;

public interface UpdateCourse {
    /**
     * retrieve the AllCourses list here.
     */
    Map<String, CoursePage> linked_page = AllCourses.linked_page;
    void update_course_info(String course_code, String course_info, String course_year);
}
