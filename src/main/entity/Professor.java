package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends CommentableUser {


    private ArrayList<String> taughtCourses;
    private HashMap<String, ArrayList<Comment>> comments = new HashMap<>();


    public Professor(String identifier, String userName, String password) {
        super(identifier, userName, password);
        HashMap<String, ArrayList<Comment>> comments= new HashMap<>();
        ArrayList<String> taughtCourses = new ArrayList<>();
    }

    /**
     * @return return professor's taught courses.
     */
    public ArrayList<String> getTaughtCourses() {
        return taughtCourses;
    }

    /**
     * @return return professor's comments.
     */
    public HashMap<String, ArrayList<Comment>> getComments() {
        return comments;
    }

    /**
     * @return String "Professor" as an indicator of this class.
     */
    @Override
    public String getClassString() {
        return "Professor";
    }

    /**
     * @param teachCourse A list of course that professor taught
     */
    // Setter
    public void setTaughtCourses(ArrayList<String> teachCourse) {
        this.taughtCourses = teachCourse;
    }

}