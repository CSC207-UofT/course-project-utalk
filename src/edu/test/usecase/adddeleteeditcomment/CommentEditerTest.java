package usecase.adddeleteeditcomment;

import entity.Professor;
import entity.Student;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class CommentEditerTest {
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

        System.out.println(CommentAdder.addComment(professor, "csc207", "I am a professor.", 0));

        System.out.println(CommentEditer.editComment(professor, "csc207", "I am Professor Paul.", 1));



    }
}
