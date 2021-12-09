package interfaceadaptors;

import entity.Professor;
import entity.Student;
import interfaceadaptor.boundaries.DatabaseWriter;
import interfaceadaptor.presenter.CoursePagePresenter;
import org.junit.Before;
import org.junit.Test;
import usecase.adddeleteeditcomment.CommentAdder;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;


public class WriteAllCommentTest
{
    private Professor prof;

    @Before
    public void setUp() {
        prof = new Professor("Professor", "a", "a");
    }

    @Test
    public void testSample() {
        setUp();
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;

        CourseEnroller.enrollCourse("csc207", prof);
        CommentAdder.addComment(prof, "csc207", "aho", 0);
        CommentAdder.addComment(prof, "csc207", "keep working!", 1);
        CommentAdder.addComment(prof, "csc207", "You will learn more", 2);
        assert !AllCourses.coursePageHashMap.get("csc207").getPost_page_List().get(0).comments.isEmpty();
        DatabaseWriter.writeComment();
        // see database output
    }
}

