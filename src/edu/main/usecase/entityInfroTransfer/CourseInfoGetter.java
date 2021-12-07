package usecase.entityInfroTransfer;

import entity.Course;
import entity.CoursePage;
import usecase.javastorage.AllCourses;

import java.util.Map;

public class CourseInfoGetter {
    /**
     * @return return a HashMap of course information containing course_code, course_description, course_start_year
     */
    public static Map<String, Object> courseInfoGetter(Course course){
        return course.courseInfoGetter();
    }
    public static CoursePage courseGetter(String course){
        return AllCourses.coursePageHashMap.get(course);
    }

}
