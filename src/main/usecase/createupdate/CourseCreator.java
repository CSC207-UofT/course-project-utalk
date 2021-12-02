package usecase.createupdate;
import entity.Course;
import entity.CoursePage;
import usecase.javastorage.AllCourses;

public class CourseCreator {
    public static void createCourse(String course_name, String description, String year)
    {
        if (AllCourses.coursePageHashMap.containsKey(course_name)){
            System.out.println("Course Already Exist, please do update course");
        } else{
            Course new_course = new Course(course_name, description, year);
            CoursePage course_page = new CoursePage(new_course);
            AllCourses.coursePageHashMap.put(course_name, course_page);
            System.out.println("Course added Successfully");
        }
    }
}