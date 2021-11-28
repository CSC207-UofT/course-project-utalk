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


    public boolean noaccessComment(String course_code, int comment_id) {
        if (comments.containsKey(course_code)) {


        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
        int length = coursepage.getLength();
        PostPage postpage = coursepage.post_page_List.get(length - 1);

        if (postpage.current_id >= comment_id) {

            return !postpage.comments.get(comment_id).getAuthor().equals(this.user_name);
        }}

        return true;

    }



    public void addComment(String course_code, String content, Integer replyID ){
        if (!canAddComment(course_code, replyID)){
            System.out.println("can't add");
        }
        else{
            Comment comment = new Comment(this.user_name, content, course_code, 0);
            comment.addComment();

        }

    }








    public void deleteComment(String course_code, int comment_id){
        if (noaccessComment(course_code, comment_id)){
            System.out.println("can not delete!");
        }
        else{
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.comments.get(comment_id).deleteComment();
            System.out.println("succeed");
        }
    }

    public void editComment(String course_code, int comment_id, String content){
        if (noaccessComment(course_code, comment_id)){
            System.out.println("can not edit!");
        }
        else{
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.comments.get(comment_id).editComment(content);
            System.out.println("succeed");
        }
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
