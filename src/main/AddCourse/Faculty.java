package AddCourse;

import basics.Course;
import basics.User;

public class Faculty extends User implements CreateCourse{
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


}
