package usecase.javastorage;

import entity.Professor;

import java.util.ArrayList;
import java.util.HashMap;

public class AllProfessors {
    public static HashMap<String, Professor> ProfessorHashMap = new HashMap<>();
    public static ArrayList<ArrayList<String>> recordProfessor(){
        ArrayList<ArrayList<String>> wholeList = new ArrayList<>();
        for (String name: AllProfessors.ProfessorHashMap.keySet()){
            Professor currProfessor = AllProfessors.ProfessorHashMap.get(name);
            ArrayList<String> enrolledCourse = currProfessor.getCourseList();
            enrolledCourse.add(0, name);
            wholeList.add(enrolledCourse);
        }
        return wholeList;

    }


}

