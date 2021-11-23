package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
    private ArrayList<String> student_course;
    private String password;
    private HashMap<String, ArrayList<Comment>> student_comments = new HashMap<>();

    public Student(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
    }

    public HashMap<String, ArrayList<Comment>> getStudent_comments() {
        return student_comments;
    }

    public void setStudent_comments(HashMap<String, ArrayList<Comment>> student_comments) {
        this.student_comments = student_comments;
    }

}