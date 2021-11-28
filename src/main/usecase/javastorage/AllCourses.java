package usecase.javastorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import entity.Course;
import entity.CoursePage;

public class AllCourses {
    public static HashMap<String, CoursePage> coursePageHashMap = new HashMap<>();
    public static ArrayList<ArrayList<String>> recordCourses(){
        ArrayList<ArrayList<String>> courses = new ArrayList<>();
        for (String course : AllCourses.coursePageHashMap.keySet()){
            Course course1 = AllCourses.coursePageHashMap.get(course).course;
            String courseInfo = (String) course1.courseInfoGetter().get("description");
            String courseStartYear = course1.course_start_year;
            ArrayList<String> currentCourse = new ArrayList<>(Arrays.asList(course,courseInfo, courseStartYear));
            courses.add(currentCourse);
        }
        return courses;
    }

}
