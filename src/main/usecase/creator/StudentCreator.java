package usecase.creator;

import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllStudents;

import java.util.ArrayList;

public class StudentCreator {
    public static void createStudent(ArrayList<ArrayList<String>> students){
        for (ArrayList<String> student: students){
            String studentName = student.get(0);
            assert AllStudents.StudentHashMap.get(studentName) == null;
            for (int i = 1; i < student.size(); i++){
                CourseEnroller.enrollCourse(student.get(i),
                        AllStudents.StudentHashMap.get(studentName));
            }
        }
    }
}
