package usecase.entityInfroTransfer;

import entity.Comment;
import entity.CommentableUser;

import java.util.ArrayList;

public class CommentableUserInfoTransfer {
    //TODO: add javadoc for this and other methods in this folder
    public static ArrayList<String> getCourseList(CommentableUser commentableUser){
        return commentableUser.getCourseList();
    }
    public static ArrayList<Comment> getCourseComment(String course, CommentableUser commentableUser) {
        if (commentableUser.getComments().containsKey(course)) {
            return commentableUser.getComments().get(course);
        }
        return new ArrayList<>();
        // empty comment
    }
}
