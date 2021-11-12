package AddCourse;

/* try to do a facade pattern for this one */

import basics.Course;

public class CreateCourse {
    public void create_course(String course_name, String description, String year)
    {
        if (AllCourses.coursePageHashMap.containsKey(course_name)){
            System.out.println("Course Already Exist, please do update course");
        } else{
        Course new_course = new Course(course_name, description, year);
        CoursePage course_page = new CoursePage(new_course);
        AllCourses.coursePageHashMap.put(course_name, course_page);}
    }
}
