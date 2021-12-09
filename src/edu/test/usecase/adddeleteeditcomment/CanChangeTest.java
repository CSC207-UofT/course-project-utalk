package usecase.adddeleteeditcomment;

import entity.Professor;
import org.junit.jupiter.api.Test;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import org.junit.jupiter.api.Assertions;



public class CanChangeTest {
    @Test
    public void testCanAdd(){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        Professor professor = new Professor("16", "Paul", "207");
        AllCommentableUser.getAllCommentableUsers().put(professor.user_name, professor);
        CourseEnroller.enrollCourse("csc207", professor);
        Assertions.assertTrue(CanChange.canAddComment("csc207", 0, professor));



    }
}
