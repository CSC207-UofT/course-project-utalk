package usecase.creator;

import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllProfessors;

import java.util.ArrayList;

public class ProfessorCreator {
    public static void createProfessor(ArrayList<ArrayList<String>> professors){
        for (ArrayList<String> professor: professors){
            String professorName = professor.get(0);
            professor.remove(0);
            for (String course: professor){
                CourseEnroller.teachingCourse(course, AllProfessors.ProfessorHashMap.get(professorName));
            }
        }
    }
}
