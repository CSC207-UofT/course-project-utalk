package interfaceadaptor;

import entity.Faculty;
import entity.Professor;
import entity.Student;
import entity.User;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllProfessors;
import usecase.javastorage.AllStudents;

import java.util.ArrayList;
import java.util.Objects;

public class AllReader {
    public static void readAll(){
        ArrayList<ArrayList<String>> users = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/user.csv");
        ArrayList<ArrayList<String>> courses = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/courses.csv");
        ArrayList<ArrayList<String>> students = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/students.csv");
        ArrayList<ArrayList<String>> professors = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/professors.csv");
        for (ArrayList<String> user: users){
            if (Objects.equals(user.get(3), "student")){
                Student student = new Student(user.get(0), user.get(1), user.get(2));
                AllStudents.StundetHashMap.put(user.get(1), student);
            } else if (Objects.equals(user.get(3), "professor")){
                Professor professor = new Professor(user.get(0), user.get(1), user.get(2));
                AllProfessors.ProfessorHashMap.put(user.get(1), professor);
            }
        }
        for (ArrayList<String> course: courses){
            CourseCreator.createCourse(course.get(0), course.get(1), course.get(2));
        }
        for (ArrayList<String> student: students){
            String studentName = student.get(0);
            for (String course:student){
                CourseEnroller.enrollCourse(course, AllStudents.StundetHashMap.get(studentName));
            }
        }
        for (ArrayList<String> professor: professors){
            String professorName = professor.get(0);
            for (String course: professor){
                CourseEnroller.teachingCourse(course, AllProfessors.ProfessorHashMap.get(professorName));
            }
        }
    }
}
