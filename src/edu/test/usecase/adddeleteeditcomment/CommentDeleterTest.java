package usecase.adddeleteeditcomment;

import entity.Professor;
import entity.Student;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class CommentDeleterTest {
    public static void main(String[] args) {
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        Professor professor = new Professor("16", "Paul", "207");
        Student student = new Student("1", "Judd", "3");
        AllCommentableUser.getAllCommentableUsers().put(student.user_name, student);
        CourseEnroller.enrollCourse("csc207", student);
        AllCommentableUser.getAllCommentableUsers().put(professor.user_name, professor);
        CourseEnroller.enrollCourse("csc207", professor);
        System.out.println(CommentAdder.addComment(professor, "csc207", "Hello everyone!", 0));
        System.out.println(CommentAdder.addComment(student, "csc207", "Hello professor!", 0));
        System.out.println(CommentAdder.addComment(student, "csc207", "I am a student.", 0));
        System.out.println(CommentAdder.addComment(professor, "csc207", "I am a professor.", 0));
        //student can delete his own comment but not others
        System.out.println(CommentDeleter.deleteComment(student,"csc207", 1));
        System.out.println(CommentDeleter.deleteComment(student,"csc207", 2));
        //professor can delete his own comment
        System.out.println(CommentDeleter.deleteComment(professor,"csc207", 4));
        //with the deleteCommentProf methods, a professor can delete others comment
        System.out.println(CommentDeleter.deleteCommentProf(professor,"csc207", 3));
    }
}
