package interfaceadaptors;

import entity.Professor;
import entity.Student;
import interfaceadaptor.boundaries.DatabaseWriter;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class WriteAllCommentableUserTest {
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        Professor professor = new Professor("16", "Caroline", "207");
        AllCommentableUser.getAllCommentableUsers().put(professor.user_name, professor);
        CourseEnroller.enrollCourse("csc207", professor);
        CourseEnroller.enrollCourse("csc200", professor);
        DatabaseWriter.writeCommentableUser();
        Student student = new Student("1", "2", "3");
        AllCommentableUser.getAllCommentableUsers().put(student.user_name, student);
        CourseEnroller.enrollCourse("csc207", student);
        CourseEnroller.enrollCourse("csc200", student);
        DatabaseWriter.writeCommentableUser();
    }
}
