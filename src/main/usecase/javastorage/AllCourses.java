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
            String addedInfo = AllCourses.coursePageHashMap.get(course).info_added;
            String currentYear = AllCourses.coursePageHashMap.get(course).
                    post_page_List.get(AllCourses.coursePageHashMap.get(course).post_page_List.size()-1).semesterGetter();
            ArrayList<String> currentCourse = new ArrayList<>(Arrays.asList(course,courseInfo, courseStartYear,
                    addedInfo, currentYear));
            courses.add(currentCourse);
        }
        return courses;
    }
    public static HashMap<String, CoursePage> getCoursePageHashMap(){
        return coursePageHashMap;
    }

}
