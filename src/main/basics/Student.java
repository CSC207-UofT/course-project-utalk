package basics;

import AddCourse.CoursePage;
import AddCourse.PostPage;
import Comment.Commentable;

import java.util.ArrayList;

public class Student extends User implements Commentable{
    private ArrayList<Comment> student_comments;
    private ArrayList<CoursePage> student_course;
    private String identifier;
    private String user_name;
    private String password;
    // Do we need to restate the instance attribute for student?
    public Student(String student_name, String identifier, String password){
        super(student_name, identifier, password);
        this.password = password;
        student_comments = new ArrayList<>();
    }
    void add_course(String course_name){
    }


    //    @Override
//    public String toString(){
//        return identifier + ":" + user_name;
//    }
//
    public boolean passwordMatches(String password) {
        return password.equals(this.password);
    }


    /**
     * Method for adding a comment
     * @param semester the current semester
     * @param pp the PostPage the Comment is being added to
     * @param c an instance of the class Comment
     * @param edit an instance of String
     * @return true if the comment has been edited successfully
     */
    public boolean editComment(String semester, PostPage pp, Comment c, String edit) {
        if(!pp.getSemester().equals(semester)){
            return false;
        }
        else if (!this.student_comments.contains(c)){
            return false;
        }
        else{
            c.editComment(edit);
            return true;
        }
    }

    /**
     * Method for adding a comment
     * @param semester the current semester
     * @param pp the PostPage the Comment is being added to
     * @param c an instance of the class Comment
     * @return true if the comment has been added successfully
     */
    public boolean addComment(String semester, PostPage pp, Comment c) {
        if (!pp.getSemester().equals(semester)){
            return false;
        }
        else{
            pp.addComment(c);
            this.student_comments.add(c);
            return true;
        }
    }

    /**
     * Method for adding replies to a comment
     * @param semester the current semester
     * @param pp the PostPage the Comment is being added to
     * @param c an instance of the class Comment
     * @param reply a reply to the Comment c
     * @return true if the comment has been added successfully
     */
    public boolean addComment(String semester, PostPage pp, Comment c, Comment reply) {
        if (!pp.getSemester().equals(semester)) {
            return false;
        }
        else{
            c.addReply(reply);
            this.student_comments.add(reply);
            return true;
        }
    }

    /**
     * Method for deleting comments
     * @param semester the current semester
     * @param pp the PostPage the Comment is being deleted from
     * @param c the Comment to be deleted
     * @return true if the comment is deleted and false otherwise
     */

    public boolean deleteComment(String semester, PostPage pp, Comment c) {
        if (!pp.getSemester().equals(semester)) {
            return false;
        }
        else if (!this.student_comments.contains(c)){
            return false;
        }
        else{
            pp.deleteComment(c);
            this.student_comments.remove(c);
            return true;
        }
    }
}