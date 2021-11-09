package AddCourse;

import java.util.Map;
import java.util.Objects;

public class UpdateCourse {
    public void update_course_info(String course_code, String course_info, String course_year) {
        Map<String, CoursePage> link_page = AllCourses.linked_page;
        if (link_page.containsKey(course_code)){
            CoursePage coursepage = link_page.get(course_code);
            link_page.get(course_code).info_added = course_info;
            if (!Objects.equals(coursepage.course.course_start_year, course_year)){
                PostPage new_postpage = new PostPage(course_year);
                link_page.get(course_code).post_page_List.add(new_postpage);
            }
        } else {
            System.out.println("The course has not been created yet.");
        }
    }
}
