package usecase.adddeleteeditcomment;

import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class CommentEditerTest {
    @Test
    public void testEditComment(){

        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        Professor professor = new Professor("16", "Paul", "207");
        AllCommentableUser.getAllCommentableUsers().put(professor.user_name, professor);
        CourseEnroller.enrollCourse("csc207", professor);
        CommentAdder.addComment(professor, "csc207", "Hello everyone", 0);
        CoursePage coursePage = AllCourses.getCoursePageHashMap().get("csc207");
        PostPage postpage = coursePage.getPostPage(0);
        Comment comment = postpage.getComments().get(1);
        CommentEditer.editComment(professor, "csc207", "I am Professor Paul.", 1);
        Assertions.assertEquals(comment.getComment(), "I am Professor Paul.");

    }

}
