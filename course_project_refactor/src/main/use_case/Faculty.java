package use_case;

import entity.User;
import use_case.CreateandUpdate.CreateCourse;
import use_case.CreateandUpdate.UpdateCourse;

public class Faculty extends User {
    public Faculty(String identifier, String name, String password){
        super(identifier, name, password);
    }
    CreateCourse createCourse = new CreateCourse();
    UpdateCourse updateCourse = new UpdateCourse();

    public void create_course(String course_name, String description, String year)
    {
        createCourse.create_course(course_name, description, year);
    }

    public void update_course_info(String course_code, String course_info, String course_year) {
        updateCourse.update_course_info(course_code, course_info, course_year);
    }
}
