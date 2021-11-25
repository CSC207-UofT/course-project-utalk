package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
    private ArrayList<String> studentCourse;
    private String password;
    private HashMap<String, ArrayList<Comment>> studentComments = new HashMap<>();

    public Student(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
    }

    public HashMap<String, ArrayList<Comment>> getStudentComments() {
        return studentComments;
    }

    public void setStudentComments(HashMap<String, ArrayList<Comment>> student_comments) {
        this.studentComments = student_comments;
    }

}