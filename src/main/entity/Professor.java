package entity;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import usecase.javastorage.AllCourses;

public class Professor extends CommentableUser {


    private ArrayList<String> taughtCourses = new ArrayList<String>();
    private HashMap<String, ArrayList<Comment>> comments = new HashMap<>();


    public Professor(String identifier, String userName, String password) {
        super(identifier, userName, password);
        HashMap<String, ArrayList<Comment>> comments= new HashMap<>();
        ArrayList<String> taughtCourses = new ArrayList<>();
    }

    public boolean canDeleteComment(String course_code, int comment_id){
        if(! taughtCourses.contains(course_code)){
            return false;
        }
        int length = AllCourses.coursePageHashMap.get(course_code).getLength();
        PostPage postpage = AllCourses.coursePageHashMap.get(course_code).getPostPage(length-1);
        return postpage.current_id >= comment_id;

    }
    @Override
    public void deleteComment(String course_code, int comment_id){
        if (! canDeleteComment(course_code, comment_id)){
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

    /**
     * @return return professor's taught courses.
     */
    public ArrayList<String> getTaughtCourses() {
        return taughtCourses;
    }

    /**
     * @return return professor's comments.
     */
    public HashMap<String, ArrayList<Comment>> getComments() {
        return comments;
    }

    /**
     * @return String "Professor" as an indicator of this class.
     */
    @Override
    public String getClassString() {
        return "Professor";
    }

    /**
     * @param teachCourse A list of course that professor taught
     */
    // Setter
    public void setTaughtCourses(ArrayList<String> teachCourse) {
        this.taughtCourses = teachCourse;
    }

}