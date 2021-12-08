package usecase.javastorage;
import usecase.createupdate.CourseCreator;

import java.util.Objects;

class JavaStorageTest {
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        assert AllCourses.recordCourses().size() == 2;
        assert Objects.equals(AllCourses.recordCourses().get(0).get(0), "csc207");
    }
}