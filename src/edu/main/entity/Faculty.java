package entity;

import usecase.createupdate.CourseCreator;
import usecase.createupdate.CourseUpdater;

public class Faculty extends User {
    public Faculty(String identifier, String name, String password){
        super(identifier, name, password);
    }

    @Override
    public String getUserName() {
        return this.user_name;
    }

    CourseCreator createCourse = new CourseCreator();
    CourseUpdater updateCourse = new CourseUpdater();

    /**Create a course with the course name, description and the course year
     * @param course_name the name of the course
     * @param description the description of the course
     * @param year the course year of that course
     */
    public void createCourse(String course_name, String description, String year)
    {
        createCourse.createCourse(course_name, description, year);
    }

    /**update the course code with description and the course year
     * @param course_code the name of the course
     * @param course_info the information of that course
     * @param course_year the new course year
     */
    public void updateCourseInfo(String course_code, String course_info, String course_year) {
        updateCourse.updateCourseInfo(course_code, course_info, course_year);
    }
}
