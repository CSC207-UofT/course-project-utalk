package usecase.adddeleteeditcomment;

import entity.Professor;
import entity.Student;
import org.junit.Before;
import org.junit.Test;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class CommentAdderTest {
    private Professor professor;

    @Before
    public void setUp() {
        professor = new Professor("16", "Paul", "207");
    }

    @Test
    public void testSample() {
        setUp();
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        AllCommentableUser.getAllCommentableUsers().put(professor.user_name, professor);
        CourseEnroller.enrollCourse("csc207", professor);
        System.out.println(CommentAdder.addComment(professor, "csc207", "Hello everyone", 0));
    }
}
