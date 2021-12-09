package outerlayer.userinterface.studentprofessorinterface;

import entity.CommentableUser;
import entity.Student;
import usecase.createupdate.CourseCreator;
import usecase.javastorage.AllCommentableUser;
import org.junit.Before;
import org.junit.Test;


public class EnrollandDropCourseUITest
{
    private CommentableUser cmu;

    @Before
    public void setUp() {
        cmu = new Student("hello", "1", "1");
    }

    @Test
    public void testSample() {
        setUp();
        CourseCreator.createCourse("csc207", "hello", "hello");
        AllCommentableUser.getAllCommentableUsers().put("hello", cmu);
        EnrollAndDeleteCourseUI.enrollAndDropCoursePage();
    }
}
