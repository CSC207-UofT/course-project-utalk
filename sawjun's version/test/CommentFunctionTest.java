package test;
import main.usecase.CommentAdder;
import main.usecase.CommentEditor;
import main.usecase.CommentDeleter;
import main.entity.Student;
import main.entity.Professor;
import main.entity.CoursePageMap;
import main.entity.CoursePage;
import main.entity.PostPage;
import main.entity.Course;
import main.entity.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CommentFunctionTest {
    @Test
    void testCommentFunction(){
        Course c = new Course("CSC108", "Intro", "2019");
        CoursePage cp = new CoursePage(c);
        PostPage pp = new PostPage("2019");
        cp.addPostPage(pp);
        CoursePageMap cpm = new CoursePageMap();
        cpm.getMap().put("CSC108", cp);
        Student s = new Student("student", "password");
        s.getEnrolledcourses().put("CSC108", "2019");
        Professor p = new Professor("professor", "password");
        ArrayList<String> sems = new ArrayList<>();
        sems.add("2019");
        p.getTaughtcourses().put("CSC108", sems);
        CommentAdder cas = new CommentAdder(s);
        CommentAdder cap = new CommentAdder(p);
        Assertions.assertEquals
                (cas.addComment(cpm, "CSC108", "Hello"), CommentAdder.AddCommentStatus.ADDED);
        Comment a = s.getComments().get("CSC108 2019").get(0);
        Assertions.assertEquals
                (cap.addReply(cpm, "CSC108", a, "Hello"), CommentAdder.AddCommentStatus.ADDED);
        System.out.println(pp.getCommentList().get(1).getComment());
        System.out.println(a.getReplies().get(1).getComment());
        CommentEditor ces = new CommentEditor(s);
        CommentEditor cep = new CommentEditor(p);
        Assertions.assertEquals(ces.editComment(cpm, "CSC108", 1, "Hi"),
                CommentEditor.EditCommentStatus.EDITED);
        Assertions.assertEquals(cep.editInnerComment(cpm, "CSC108", a, 1, "Hi"),
                CommentEditor.EditCommentStatus.EDITED);
        System.out.println(pp.getCommentList().get(1).getComment());
        System.out.println(a.getReplies().get(1).getComment());
        CommentDeleter cds = new CommentDeleter(s);
        CommentDeleter cps = new CommentDeleter(p);
        Assertions.assertEquals(cds.deleteComment(cpm, "CSC108", 1),
                CommentDeleter.DeleteCommentStatus.DELETED);
        Assertions.assertEquals(cps.deleteInnerComment(cpm, "CSC108", a, 1),
                CommentDeleter.DeleteCommentStatus.DELETED);
        System.out.println(pp.getCommentList().get(1).getComment());
        System.out.println(a.getReplies().get(1).getComment());
    }

}
