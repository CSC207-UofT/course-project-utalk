package usecase.enroldropcourse;

import entity.Professor;
import entity.Student;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.enrolldropcourse.CourseDropper;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class CourseDropperTest {

    public static void main(String[] args){

        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        Professor professor = new Professor("16", "Paul", "207");
        AllCommentableUser.getAllCommentableUsers().put(professor.user_name, professor);
        CourseEnroller.enrollCourse("csc207", professor);
        CourseDropper.dropCourse("csc207", professor);
        CourseDropper.dropCourse("csc200", professor);


        Student student = new Student("1", "Judd", "3");
        AllCommentableUser.getAllCommentableUsers().put(student.user_name, student);
        CourseEnroller.enrollCourse("csc207", student);
        CourseDropper.dropCourse("csc207", student);
        CourseDropper.dropCourse("csc200", student);
    }

}
