package usecase.javastorage;

import entity.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class AllStudents {
    public static HashMap<String, Student> StudentHashMap = new HashMap<>();
    public static ArrayList<ArrayList<String>> recordStudent(){
        ArrayList<ArrayList<String>> wholeList = new ArrayList<>();
        for (String name: AllStudents.StudentHashMap.keySet()){
            Student currStudent = AllStudents.StudentHashMap.get(name);
            ArrayList<String> enrolledCourse = currStudent.getCourseList();
            enrolledCourse.add(0, name);
            wholeList.add(enrolledCourse);
        }
        return wholeList;

    }
}
