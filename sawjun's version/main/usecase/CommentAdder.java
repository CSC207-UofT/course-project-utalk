package main.usecase;

import main.entity.*;

import java.util.ArrayList;

/**
 * Use Case Class for adding comments
 */
public class CommentAdder{
    private final CommentableUser cu;

    public CommentAdder(CommentableUser cu){
        this.cu = cu;
    }

    /**
     * Output of all methods related to adding comments
     */
    public enum AddCommentStatus {
        ADDED,
        CANNOT_ADD,
    }

    /**
     * Method for adding comment to main.entity.PostPage directly
     * @param coursePageMap a non-empty map that stores all existing CoursePages
     * @param courseName the course name of the course
     * @param comment the user's input
     * @return
     * - ADDED if the comment has been added successfully
     * - CANNOT_ADD if the main.entity.CommentableUser does not have permission to add comments
     */

    public AddCommentStatus addComment(CoursePageMap coursePageMap, String courseName, String comment) {
        Comment c = new Comment(this.cu, comment);
        CoursePage cp = coursePageMap.getMap().get(courseName);
        PostPage pp = cp.getPostPage(cp.getLength() - 1);
        String semester = pp.getSemester();
        if (cu.canAddComment(courseName, semester)){
            pp.addComment(c);
            String s = courseName + " " + semester;
            this.addComments(s, c);
            return AddCommentStatus.ADDED;
        }
        return AddCommentStatus.CANNOT_ADD;
    }

    /**
     * Method for adding a reply to a main.entity.Comment
     * @param coursePageMap a non-empty map that stores all existing CoursePages
     * @param courseName the course name of the main.entity.Course
     * @param comment the comment accesed by the user
     * @param reply the reply inputted by the user
     * @return
     * - ADDED if the comment has been added successfully
     * - CANNOT_ADD if the main.entity.CommentableUser does not have permission to add comments
     */
    public AddCommentStatus addReply(CoursePageMap coursePageMap, String courseName, Comment comment, String reply){
        //Assuming comment exists and is given by outer layer
        Comment c = new Comment(this.cu, reply);
        comment.addReply(c);
        CoursePage cp = coursePageMap.getMap().get(courseName);
        PostPage pp = cp.getPostPage(cp.getLength() - 1);
        String semester = pp.getSemester();
        if (cu.canAddComment(courseName, semester)){
            String s = courseName + " " + semester;
            this.addComments(s, c);
            return AddCommentStatus.ADDED;
        }
        return AddCommentStatus.CANNOT_ADD;
    }

    /**
     * Private helper function for adding Comments
     * Checks if the main.entity.CommentableUser has commented before and stores the comment in the Commentable main.entity.User
     */
    private void addComments(String key, Comment comment){
        if (!this.cu.getComments().containsKey(key)) {
            ArrayList<Comment> a = new ArrayList<>(100);
            this.cu.getComments().put(key, a);
        }
        this.cu.getComments().get(key).add(comment);

    }
}
