package AddCourse;

import basics.Course;
import basics.User;

import java.util.Objects;

public class Faculty extends User implements CreateCourse, UpdateCourse{
    public Faculty(String identifier, String name, String password){
        super(identifier, name, password);
    }

    @Override
    public void creat_course(String course_name, String description, String year)
    {
        Course new_course = new Course(course_name, description, year);
        CoursePage course_page = new CoursePage(new_course);
        AllCourses.linked_page.put(course_name, course_page);
    }


    @Override
    public void update_course_info(String course_code, String course_info, String course_year) {
        if (UpdateCourse.linked_page.containsKey(course_code)){
            CoursePage coursepage = linked_page.get(course_code);
            linked_page.get(course_code).info_added = course_info;
            if (!Objects.equals(coursepage.course.course_start_year, course_year)){
                PostPage new_postpage = new PostPage(course_year);
                linked_page.get(course_code).post_page_List.add(new_postpage);
            }
        } else {
            System.out.println("The course has not been created yet.");
        }
    }
}
