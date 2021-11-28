package usecase.javastorage;

import entity.CoursePage;
import entity.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class AllStudents {
    public static HashMap<String, Student> StundetHashMap = new HashMap<>();
    public static ArrayList<ArrayList<String>> recordStudent(){
        ArrayList<ArrayList<String>> wholeList = new ArrayList<>();
        for (String name: AllStudents.StundetHashMap.keySet()){
            Student currStudent = AllStudents.StundetHashMap.get(name);
            ArrayList<String> enrolledCourse = currStudent.getStudentCourses();
            enrolledCourse.add(0, name);
            wholeList.add(enrolledCourse);
        }
        return wholeList;

    }

}
