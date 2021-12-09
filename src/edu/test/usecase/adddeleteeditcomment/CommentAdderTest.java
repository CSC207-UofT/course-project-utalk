package usecase.adddeleteeditcomment;

import entity.Comment;
import entity.CoursePage;
import entity.PostPage;
import entity.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class CommentAdderTest {
    @Test
    public void testAddComment(){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        Professor professor = new Professor("16", "Paul", "207");
        AllCommentableUser.getAllCommentableUsers().put(professor.user_name, professor);
        CourseEnroller.enrollCourse("csc207", professor);
        CommentAdder.addComment(professor, "csc207", "Hello everyone", 0);
        CoursePage coursePage = AllCourses.getCoursePageHashMap().get("csc207");
        PostPage postpage = coursePage.getPostPage(0);
        Comment comment = postpage.getComments().get(1);
        Assertions.assertEquals(comment.getReplyTo(), 0);
        Assertions.assertEquals(comment.getComment(), "Hello everyone");
        Assertions.assertEquals(comment.getId(), 1);
        Assertions.assertEquals(comment.getCourseCode(), "csc207");


    }

}
