package usecase.createupdate;

import usecase.createupdate.CourseCreator;
import usecase.createupdate.CourseUpdater;
import usecase.javastorage.AllCourses;

public class CourseUpdatorTest {
    public static void main(String[] args) {
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseUpdater.updateCourseInfo("csc207", "hello", "fall 2021");
        assert AllCourses.coursePageHashMap.get("csc207").course.courseInfoGetter().get("description") == "hello";
    }
}
