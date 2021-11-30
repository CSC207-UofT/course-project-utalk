package interfaceadaptor.readers;

import entity.Professor;
import entity.Student;
import interfaceadaptor.CsvReader;
import usecase.creator.ProfessorCreator;
import usecase.creator.StudentCreator;
import usecase.javastorage.AllProfessors;
import usecase.javastorage.AllStudents;

import java.util.ArrayList;
import java.util.Objects;

public class AllReader {
    public static void readAll(){
        ArrayList<ArrayList<String>> users = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/user.csv");
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
        CourseReader.readCourse();
        StudentCreator.createStudent(students);
        ProfessorCreator.createProfessor(professors);

    }
}
