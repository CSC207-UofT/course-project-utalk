package test;

import main.entity.Comment;
import main.entity.Student;
import main.entity.CommentableUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;


public class CommentableUserTest {
    CommentableUser user = new Student("username", "password");

    @Test
    @DisplayName("Tests CommentableUser.getComments()")
    void testGetters(){
        Assertions.assertTrue(user.getComments().isEmpty());
    }

    @Test
    @DisplayName("Test CommentableUser.canEditComment()")
    void testCanEditComment(){
        HashMap<String, String> courses = ((Student)user).getEnrolledcourses();
        HashMap<String, ArrayList<Comment>> commentmap = user.getComments();
        Comment c = new Comment(user, "123");
        Assertions.assertFalse(user.canEditComment("abc 202", c));
        courses.put("abc", "202");
        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(c);
        commentmap.put("abc 202", comments);
        Assertions.assertTrue(user.canEditComment("abc 202", c));
    }

}
