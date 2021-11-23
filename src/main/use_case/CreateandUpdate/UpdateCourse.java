package use_case.CreateandUpdate;

import use_case.JavaStorage.AllCourses;
import entity.CoursePage;
import entity.PostPage;

import java.util.Map;
import java.util.Objects;

public class UpdateCourse {
    public void update_course_info(String course_code, String course_info, String course_year) {
        Map<String, CoursePage> link_page = AllCourses.coursePageHashMap;
        if (link_page.containsKey(course_code)){
            CoursePage coursepage = link_page.get(course_code);
            link_page.get(course_code).info_added = course_info;
            if (!Objects.equals(coursepage.course.course_start_year, course_year)){
                PostPage new_postpage = new PostPage(course_year);
                link_page.get(course_code).post_page_List.add(new_postpage);
            }
            System.out.println("Course has been updated successfully.");
        } else {
            System.out.println("The course has not been created yet.");
        }
    }
}
