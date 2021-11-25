package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends User {


    private ArrayList<String> taughtCourses;
    private HashMap<String, ArrayList<Comment>> comments = new HashMap<>();


    public Professor(String identifier, String userName, String password) {
        super(identifier, userName, password);
        HashMap<String, ArrayList<Comment>> comments= new HashMap<>();
        ArrayList<String> taughtCourses = new ArrayList<>();
    }
    // Getter
    public ArrayList<String> getTaughtCourses() {
        return taughtCourses;
    }
    public HashMap<String, ArrayList<Comment>> getComments() {
        return comments;
    }

    // Setter
    public void setTaughtCourses(ArrayList<String> teachCourse) {
        this.taughtCourses = teachCourse;
    }

}