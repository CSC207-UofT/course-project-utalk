package use_case;

import entity.Comment;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends User {

    private ArrayList<String> taught_courses;
    private HashMap<String, ArrayList<Comment>> comments = new HashMap<>();


    Professor(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
        HashMap<String, ArrayList<Comment>> comments= new HashMap<>();
        ArrayList<String> taught_courses = new ArrayList<>();
    }

}