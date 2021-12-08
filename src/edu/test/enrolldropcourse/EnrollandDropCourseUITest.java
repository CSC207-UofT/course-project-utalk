package enrolldropcourse;

import entity.CommentableUser;
import entity.Student;
import interfaceadaptor.loginlogout.Login;
import outerlayer.userinterface.studentprofessorinterface.EnrollAndDeleteCourseUI;
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
