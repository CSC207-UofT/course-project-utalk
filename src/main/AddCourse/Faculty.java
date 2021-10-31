package AddCourse;

import basics.User;


public class Faculty extends User {
    public Faculty(String identifier, String name, String password){
        super(identifier, name, password);
    }

    public void create_course(String course_name, String description, String year)
    {
        CreateCourse createCourse = new CreateCourse();
        createCourse.create_course(course_name, description, year);
    }

    public void update_course_info(String course_code, String course_info, String course_year) {
        UpdateCourse updateCourse = new UpdateCourse();
        updateCourse.update_course_info(course_code, course_info, course_year);
    }
}
