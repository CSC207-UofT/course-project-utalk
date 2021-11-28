package interfaceadaptors;

import interfaceadaptor.boundaries.WriteIntoDatabase;
import usecase.createupdate.CourseCreator;
import usecase.javastorage.AllCourses;

public class WriteAllCourseTest {
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        WriteIntoDatabase.writeAllCourses();
    }
}
