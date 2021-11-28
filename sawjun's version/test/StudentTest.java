package test;

import main.entity.Comment;
import main.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentTest {
    Student user = new Student("username", "password");
    HashMap<String, String> map =  user.getEnrolledcourses();
    HashMap<String, ArrayList<Comment>> comments = user.getComments();

    @Nested
    @DisplayName("Tests Student.canAddComment()")
    class CanAddCommentTest{
        @Test
        void testEmptyMap(){
            Assertions.assertFalse(user.canAddComment("abc", "2019"));
        }
        @Test
        void testIncorrectKeyValue(){
            map.put("abc", "2020");
            Assertions.assertFalse(user.canAddComment("abc", "2019"));
            Assertions.assertFalse(user.canAddComment("abcd", "2020"));
        }
        @Test
        void testCorrectKeyValue(){
            map.put("abc", "2020");
            Assertions.assertTrue(user.canAddComment("abc", "2020"));
        }

    }

    @Nested
    @DisplayName("Tests Student.canDeleteComment()")
    class testCanDeleteComment{
        @Test
        void testNoEnrolledCourses(){
            Comment c = new Comment(user, "hello");
            Assertions.assertFalse(user.canDeleteComment("abc", "2019", c));
        }
        @Test
        void testNoComments(){
            Comment c = new Comment(user, "hello");
            map.put("abc", "2019");
            Assertions.assertFalse(user.canDeleteComment("abc", "2019", c));
        }
        @Test
        void testHasComments(){
            Comment c = new Comment(user, "hello");
            Comment b = new Comment(user, "hello");
            map.put("abc", "2019");
            Assertions.assertFalse(user.canDeleteComment("abc", "2019", c));
            ArrayList<Comment> usercomments = new ArrayList<>();
            usercomments.add(c);
            comments.put("abc 2019", usercomments);
            Assertions.assertFalse(user.canDeleteComment("abc","2019", b));
            Assertions.assertTrue(user.canDeleteComment("abc", "2019", c));
        }

    }

}
