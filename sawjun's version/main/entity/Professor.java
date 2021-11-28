package main.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends CommentableUser{
    private HashMap<String, ArrayList<String>> taughtcourses;

    public Professor(String username, String password){
        super(username, password);
        this.taughtcourses = new HashMap<>();
        //Key coursename, value semester
    }

    @Override
    public boolean canAddComment(String courseName, String semester) {
        if (this.taughtcourses.isEmpty()){
            return false;
        }
        if(!this.taughtcourses.containsKey(courseName)){
            return false;
        }
        return this.taughtcourses.get(courseName).contains(semester);
    }

    @Override
    public boolean canDeleteComment(String courseName, String semester, Comment comment) {
        if (!canAddComment(courseName, semester)){
            return false;
        }
        String s = courseName + " " + semester;
        if (this.getComments().get(s).contains(comment)){
            return true;
        }
        CommentableUser cu = comment.getAuthor();
        if (cu instanceof Professor){
            return false;
        }
        return cu.canAddComment(courseName, semester);
    }

    public HashMap<String, ArrayList<String>> getTaughtcourses() {
        return taughtcourses;
    }
}
