package usecase.entityInfroTransfer;

import entity.Course;
import entity.CoursePage;
import usecase.javastorage.AllCourses;

import java.util.Map;

public class CourseInfoGetter {
    public static CoursePage courseGetter(String course){
        return AllCourses.coursePageHashMap.get(course);
    }

}
