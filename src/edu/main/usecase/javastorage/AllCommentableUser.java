package usecase.javastorage;

import entity.CommentableUser;

import java.util.ArrayList;
import java.util.HashMap;

public class AllCommentableUser {
    private static HashMap<String, CommentableUser> allCommentableUsers = new HashMap<>();

    /**Give the hashmap of all commentable users
     * @return the hashmap of all commentable users
     */
    public static HashMap<String, CommentableUser> getAllCommentableUsers() {
        return allCommentableUsers;
    }

    /** set the hashmap of all commentable users
     * @param allCommentableUser the hashmap of all commentable users
     */
    public static void setAllCommentableUsers(HashMap<String, CommentableUser> allCommentableUser) {
        allCommentableUsers = allCommentableUser;
    }


    /**record all the commentableUser
     * @return the list of all commentable users
     */
    public static ArrayList<ArrayList<String>> recordCommentableUser(){
        ArrayList<ArrayList<String>> wholeList = new ArrayList<>();
        for (CommentableUser user: AllCommentableUser.getAllCommentableUsers().values()){
            ArrayList<String> enrolledCourse = new ArrayList<>();
            enrolledCourse.add(0, user.getUserName());
            enrolledCourse.addAll(user.getCourseList());
            wholeList.add(enrolledCourse);
        }
        return wholeList;

    }
}
