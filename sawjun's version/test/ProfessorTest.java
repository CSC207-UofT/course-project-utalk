package test;

import main.entity.Comment;
import main.entity.Student;
import main.entity.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfessorTest {
    Professor prof = new Professor("professor", "password");
    HashMap<String, ArrayList<String>> map1 = prof.getTaughtcourses();
    HashMap<String, ArrayList<Comment>> comments1= prof.getComments();
    Student user = new Student("student", "password");
    HashMap<String, String> map2 =  user.getEnrolledcourses();
    HashMap<String, ArrayList<Comment>> comments2= user.getComments();

    @Nested
    @DisplayName("Tests Professor.canAddComment()")
    class CanAddCommentTest{
        @Test
        void testEmptyMap(){
            Assertions.assertFalse(prof.canAddComment("abc", "2019"));
        }
        @Test
        void testIncorrectKeyValue(){
            ArrayList<String> sems = new ArrayList<>();
            sems.add("2020");
            map1.put("abc", sems);
            Assertions.assertFalse(prof.canAddComment("abc", "2019"));
            Assertions.assertFalse(prof.canAddComment("abcd", "2020"));
        }
        @Test
        void testCorrectKeyValue(){
            ArrayList<String> sems = new ArrayList<>();
            sems.add("2020");
            map1.put("abc", sems);
            Assertions.assertTrue(prof.canAddComment("abc", "2020"));
        }

    }

    @Nested
    @DisplayName("Tests Student.canDeleteComment()")
    class testCanDeleteComment{
        @Test
        void testNoTaughtCourses(){
            Comment c = new Comment(prof, "hello");
            Assertions.assertFalse(prof.canDeleteComment("abc", "2019", c));
        }
        @Test
        void testOwnComment(){
            Comment c = new Comment(prof, "hello");
            ArrayList<String> sems = new ArrayList<>();
            sems.add("2020");
            map1.put("abc", sems);
            ArrayList<Comment> profcomments = new ArrayList<>();
            comments1.put("abc 2020", profcomments);
            Assertions.assertFalse(prof.canDeleteComment("abc", "2020", c));
            profcomments.add(c);
            Assertions.assertTrue(prof.canDeleteComment("abc", "2020", c));
        }
        @Test
        void testStudentComment(){
            ArrayList<String> sems = new ArrayList<>();
            sems.add("2020");
            map1.put("abc", sems);
            map2.put("abc", "2020");
            Comment c = new Comment(user, "hello");
            ArrayList<Comment> usercomments = new ArrayList<>();
            usercomments.add(c);
            comments2.put("abc 2020", usercomments);
            ArrayList<Comment> profcomments = new ArrayList<>();
            comments1.put("abc 2020", profcomments);
            Assertions.assertTrue(prof.canDeleteComment("abc", "2020", c));

        }

    }

}
