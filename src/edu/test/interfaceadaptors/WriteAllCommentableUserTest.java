package interfaceadaptors;

import entity.Professor;
import entity.Student;
import interfaceadaptor.boundaries.DatabaseWriter;
import org.junit.Before;
import org.junit.Test;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class WriteAllCommentableUserTest {
    private Professor prof;

    @Before
    public void setUp() {
        prof = new Professor("Professor", "a", "a");
    }

    @Test
    public void testSample() {
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        AllCommentableUser.getAllCommentableUsers().put(prof.user_name, prof);
        CourseEnroller.enrollCourse("csc207", prof);
        CourseEnroller.enrollCourse("csc200", prof);
        DatabaseWriter.writeCommentableUser();
        Student student = new Student("1", "2", "3");
        AllCommentableUser.getAllCommentableUsers().put(student.user_name, student);
        CourseEnroller.enrollCourse("csc207", student);
        CourseEnroller.enrollCourse("csc200", student);
        DatabaseWriter.writeCommentableUser();
    }
}
