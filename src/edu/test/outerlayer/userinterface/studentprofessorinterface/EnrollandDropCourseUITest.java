package outerlayer.userinterface.studentprofessorinterface;

import entity.CommentableUser;
import entity.Student;
import interfaceadaptor.loginlogout.Login;
import usecase.createupdate.CourseCreator;
import usecase.javastorage.AllCommentableUser;

public class EnrollandDropCourseUITest {
    public static void main(String[] agrs){
        Login.loggedInUser = new Student("hello", "1", "1");
        CourseCreator.createCourse("csc207", "hello", "hello");
        AllCommentableUser.getAllCommentableUsers().put("hello", (CommentableUser) Login.loggedInUser);
        EnrollAndDeleteCourseUI.enrollAndDropCoursePage();
    }
}
