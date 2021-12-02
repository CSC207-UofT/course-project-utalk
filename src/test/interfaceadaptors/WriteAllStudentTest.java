package interfaceadaptors;

import entity.Student;
import interfaceadaptor.boundaries.DatabaseWriter;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCourses;
import usecase.javastorage.AllStudents;

public class WriteAllStudentTest {
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        Student student = new Student("1", "2", "3");
        AllStudents.StudentHashMap.put(student.user_name, student);
        CourseEnroller.enrollCourse("csc207", student);
        CourseEnroller.enrollCourse("csc200", student);
        DatabaseWriter.writeStudentCourses();
    }
}
