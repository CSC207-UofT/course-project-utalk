import java.util.ArrayList;

public class Faculty extends User implements CreateCourse{
    Faculty(String identifier, String name, String password){
        super(identifier, name, password);
    }

    @Override
    public void creat_course(String course_name, String description, String year)
    {
        Course new_course = new Course(course_name, description, year);
        CoursePage course_page = new CoursePage(new_course);
        AllCourses.add_to_list(course_name, course_page);
        AllCourses.linked_page.put(course_name, course_page);
    }


}