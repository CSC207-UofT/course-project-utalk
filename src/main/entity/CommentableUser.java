package entity;

import usecase.javastorage.AllCourses;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class CommentableUser extends User{
    private HashMap<String, ArrayList<Comment>> comments;

    public CommentableUser(String identifier, String username, String password) {
        super(identifier, username, password);
        this.comments = new HashMap<>();
    }

    public HashMap<String, ArrayList<Comment>> getComments(){
        return this.comments;
    }

    public boolean canAddComment(String course_code, Integer reply_to){


        if (reply_to.equals(0)){
            return this.comments.containsKey(course_code);
        }
        else {
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            return postpage.current_id >= reply_to;
        }

    }


    public boolean canAccessComment(String course_code, int comment_id) {
        if (comments.containsKey(course_code)) {


        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
        int length = coursepage.getLength();
        PostPage postpage = coursepage.post_page_List.get(length - 1);

        if (postpage.current_id >= comment_id) {

            return postpage.comments.get(comment_id).getAuthor().equals(this.user_name);
        }}

        return false;

    }

















    public abstract String getClassString();

    /**
     * @param course The course that contains comments
     * @return CommentableUser's comments on that course.
     */
    public ArrayList<Comment> getCourseComments(String course) {
        if (comments.containsKey(course)) {
            return comments.get(course);
        }
        return null;
    }

    /**
     * @return The name of specific CommentableUser.
     */
    public String getUserName() {
        return this.user_name;
    }
}
