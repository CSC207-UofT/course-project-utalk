package usecase.javastorage;

import entity.CommentableUser;

import java.util.ArrayList;
import java.util.HashMap;

public class AllCommentableUser {
    private static HashMap<String, CommentableUser> allCommentableUsers = new HashMap<>();

    public static HashMap<String, CommentableUser> getAllCommentableUsers() {
        return allCommentableUsers;
    }

    public static void setAllCommentableUsers(HashMap<String, CommentableUser> allCommentableUsers) {
        AllCommentableUser.allCommentableUsers = allCommentableUsers;
    }
    public static ArrayList<ArrayList<String>> recordCommentableUser(){
        ArrayList<ArrayList<String>> wholeList = new ArrayList<>();
        for (String name: AllCommentableUser.getAllCommentableUsers().keySet()){
            CommentableUser currUser = AllCommentableUser.getAllCommentableUsers().get(name);
            ArrayList<String> enrolledCourse = new ArrayList<>();
            enrolledCourse.add(0, name);
            enrolledCourse.addAll(currUser.getCourseList());
            wholeList.add(enrolledCourse);
        }
        return wholeList;

    }
}
