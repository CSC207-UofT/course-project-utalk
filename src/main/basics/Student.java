package basics;

import AddCourse.CoursePage;
import AddCourse.PostPage;
import Comment.AddComment;
import Comment.DeleteComment;
import Comment.EditComment;
import java.util.ArrayList;
import java.util.Objects;

public class Student extends User implements AddComment, EditComment{
    private ArrayList<Comment> student_comments;
    private ArrayList<CoursePage> student_course;
    private ArrayList<Course> courses;
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
     * Method for editing comments
     * Returns true if the comment has been edited successfully
     * Returns false otherwise
     */
    public boolean editComment(PostPage pp, Comment c, String edit) {
        if (!this.student_comments.contains(c)){
            return false;
        }
        else{
            Comment d = new Comment(c.student_id, edit);
            pp.swapComment(c, d);
            return true;
        }
    }

    /**
     * Method for adding comments to the PostPage
     * Returns true if the comment has been added successfully
     * Returns false otherwise
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
     * Returns true if the reply has been added successfully
     * Returns false otherwise
     */
    public boolean addComment(String semester, PostPage pp, Comment c, Comment reply) {
        if (!pp.getSemester().equals(semester)) {
            return false;
        }
        else{
            c.replies.add(reply);
            this.student_comments.add(reply);
            return true;
        }
    }

    /**
     * Method for deleting comments
     * Returns true if the comment has been deleted successfully
     * Returns false otherwise

    public boolean deleteComment(PostPage pp, Comment c) {
        if (!this.student_comments.contains(c)){
            return false;
        }
        else{
            pp.deleteComment(c);
            this.student_comments.remove(c);
            return true;
        }
    }

     * Method for deleting replies to a comment
     * Returns true if the reply has been deleted successfully
     * Returns false otherwise

    public boolean deleteComment(PostPage pp, Comment c, Comment reply) {
        if (!this.student_comments.contains(c)) {
            return false;
        }
        else{
            pp.deleteReply(c, reply);
            this.student_comments.remove(reply);
            return true;
        }
      }
         */

}