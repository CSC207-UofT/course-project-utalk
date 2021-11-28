package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends CommentableUser {

    private HashMap<String, ArrayList<String>> taughtcourses;

    Professor(String username, String password){
        super(username, password);
        this.taughtcourses = new HashMap<>();
        //Key coursename, value semester
    }

    // Getter
    public HashMap<String, ArrayList<String>> getTaughtCourses() {
        return this.taughtcourses;
    }

    @Override
    public boolean canAddComment(String courseName, String semester) {
        boolean b1 = this.taughtcourses.containsKey(courseName);
        boolean b2 = this.taughtcourses.get(courseName).contains(semester);
        return b1 && b2;
    }

    @Override
    public boolean canDeleteComment(String courseName, String semester, Comment comment) {
        if (canAddComment(courseName, semester)){
            return true;
        }
        String s = courseName + " " + semester;
        if (this.getComments().get(semester).contains(comment)){
            return false;
        }
        CommentableUser cu = comment.getAuthor();
        if (cu instanceof Professor){ //depending on if our specification allows professsors to delete all comments
            return false;
        }
        return cu.canAddComment(courseName, semester);
    }
}

