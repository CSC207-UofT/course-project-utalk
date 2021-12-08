package usecase.entityInfroTransfer;

import entity.CoursePage;
import usecase.javastorage.AllCourses;


public class CourseInfoGetter {
    /**
     * @param course course name
     * @return course page of that course
     */
    public static CoursePage courseGetter(String course){
        return AllCourses.coursePageHashMap.get(course);
    }

}
