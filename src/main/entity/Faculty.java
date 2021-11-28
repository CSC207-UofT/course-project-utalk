package entity;

import usecase.createupdate.CreateCourse;
import usecase.createupdate.UpdateCourse;

public class Faculty extends User {
    public Faculty(String identifier, String name, String password){
        super(identifier, name, password);
    }

    @Override
    public String getUserName() {
        return this.user_name;
    }

    CreateCourse createCourse = new CreateCourse();
    UpdateCourse updateCourse = new UpdateCourse();

    public void createCourse(String course_name, String description, String year)
    {
        createCourse.createCourse(course_name, description, year);
    }

    public void updateCourseInfo(String course_code, String course_info, String course_year) {
        updateCourse.updateCourseInfo(course_code, course_info, course_year);
    }
}
