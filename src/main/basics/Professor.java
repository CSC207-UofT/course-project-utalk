package basics;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends User{
    private ArrayList<Course> taught_courses;
    private HashMap<Integer, Comment> comments;
    Professor(String identifier, String user_name, String password){
        super(identifier, user_name, password);
        this.taught_courses = new ArrayList<>();
        this.comments = new HashMap<>();
    }
}