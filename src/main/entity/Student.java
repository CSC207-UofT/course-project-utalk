package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends CommentableUser{
    private ArrayList<String> studentCourse;
    private String password;
    private HashMap<String, ArrayList<Comment>> comments = new HashMap<>();

    public Student(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
    }

    @Override
    public String getClassString() {
        return "Student";
    }


    @Override
    public String getUserName() {
        return this.user_name;
    }

    public HashMap<String, ArrayList<Comment>> getStudentComments() {
        return comments;
    }

    public void setStudentComments(HashMap<String, ArrayList<Comment>> student_comments) {
        this.comments = student_comments;
    }


}