package main.entity;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CommentableUser extends User{
    private HashMap<String, ArrayList<Comment>> comments;

    public CommentableUser(String username, String password) {
        super(username, password);
        this.comments = new HashMap<>();
    }

    public HashMap<String, ArrayList<Comment>> getComments(){
        return this.comments;
    }

    public abstract boolean canAddComment(String courseName, String semester);

    public boolean canEditComment(String key, Comment comment){
        if (this.getComments().isEmpty()){
            return false;
        }
        if (!this.getComments().containsKey(key)){
            return false;
        }
        return this.getComments().get(key).contains(comment);
    }

    public abstract boolean canDeleteComment(String courseName, String semester, Comment comment);

}
