package interfaceadaptor.boundaries;

import interfaceadaptor.CSVWriter;
import usecase.javastorage.AllCourses;
import usecase.javastorage.AllProfessors;
import usecase.javastorage.AllStudents;


import java.util.ArrayList;

public class DatabaseWriter {
    public static void writeAllCourses(){
        ArrayList<ArrayList<String>> courses = AllCourses.recordCourses();
        CSVWriter.write_to_csv(courses, "/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/courses.csv");
    }
    public static void writeStudentCourses(){
        ArrayList<ArrayList<String>> studentCourse = AllStudents.recordStudent();
        CSVWriter.write_to_csv(studentCourse, "/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/students.csv");
    }

    public static void writeProfessorCourses(){
        ArrayList<ArrayList<String>> professorCourse = AllProfessors.recordProfessor();
        CSVWriter.write_to_csv(professorCourse, "/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/professors.csv");
    }

}
