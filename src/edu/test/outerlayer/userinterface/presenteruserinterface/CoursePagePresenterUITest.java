package outerlayer.userinterface.presenteruserinterface;

import usecase.createupdate.CourseCreator;
import usecase.javastorage.AllCourses;

public class CoursePagePresenterUITest {
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CoursePagePresenterUI.coursePagePresenterUI();
    }
}
