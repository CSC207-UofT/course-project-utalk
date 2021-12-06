package usecase.creator;

import entity.CommentableUser;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;

import java.util.ArrayList;

public class CommentableUserCreater {

    /**Create CommentableUser object based on the list
     * @param commentUserList the list of the string which contains the information of commentable user
     */
    public static void readUser(ArrayList<ArrayList<String>> commentUserList){
        for (ArrayList<String> commentUser: commentUserList){
            String name = commentUser.get(0);
            CommentableUser currUser = AllCommentableUser.getAllCommentableUsers().get(name);
            for (int i = 1; i < commentUser.size(); i++){
                CourseEnroller.enrollCourse(commentUser.get(i), currUser);
            }

        }
    }
}
