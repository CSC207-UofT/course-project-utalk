package usecase.adddeleteeditcomment;

import entity.Professor;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class CommentAdderTest {
    public static void main(String[] args) {
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        Professor professor = new Professor("16", "Paul", "207");
        AllCommentableUser.getAllCommentableUsers().put(professor.user_name, professor);
        CourseEnroller.enrollCourse("csc207", professor);
        System.out.println(CommentAdder.addComment(professor, "csc207", "Hello everyone", 0));
    }
}
