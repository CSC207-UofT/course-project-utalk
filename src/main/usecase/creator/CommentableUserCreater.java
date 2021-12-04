package usecase.creator;

import entity.CommentableUser;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCommentableUser;

import java.util.ArrayList;

public class CommentableUserCreater {
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
