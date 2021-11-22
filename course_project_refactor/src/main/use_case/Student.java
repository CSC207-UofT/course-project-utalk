package use_case;

import entity.Comment;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
    private ArrayList<String> student_course;
    private String password;
    private HashMap<String, ArrayList<Comment>> student_comments = new HashMap<>();

    protected Student(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
    }
}