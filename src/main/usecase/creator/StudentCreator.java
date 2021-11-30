package usecase.creator;

import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllStudents;

import java.util.ArrayList;

public class StudentCreator {
    public static void createStudent(ArrayList<ArrayList<String>> students){
        for (ArrayList<String> student: students){
            String studentName = student.get(0);
            student.remove(0);
            for (String course:student){
                CourseEnroller.enrollCourse(course, AllStudents.StundetHashMap.get(studentName));
            }
        }
    }
}
