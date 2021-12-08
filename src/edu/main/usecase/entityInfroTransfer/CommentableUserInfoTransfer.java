package usecase.entityInfroTransfer;

import entity.Comment;
import entity.CommentableUser;

import java.util.ArrayList;

/**
 * Transfer CommentableUser Information to outerlayer
 */
public class CommentableUserInfoTransfer {

    /**
     * @param commentableUser commentableUser
     * @return user's course list
     */
    public static ArrayList<String> getCourseList(CommentableUser commentableUser){
        return commentableUser.getCourseList();
    }

    /**
     * @param commentableUser commentableUser
     * @param course course
     * @return user's comments on that course
     */
    public static ArrayList<Comment> getCourseComment(String course, CommentableUser commentableUser) {
        if (commentableUser.getComments().containsKey(course)) {
            return commentableUser.getComments().get(course);
        }
        return new ArrayList<>();
    }
}
