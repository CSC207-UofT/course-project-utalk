package entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class PostPage {
    public HashMap<Integer, Comment> comments;
    public ArrayList<Comment> posts;


    String semester;
    public int current_id;

    public PostPage(String semester_1) {
        this.comments = new HashMap<>();
        posts = new ArrayList<>();
        semester = semester_1;
        current_id = 0;
    }

    public String semesterGetter() {
        return semester;
    }

    public HashMap<Integer, Comment> getComments() {
        return this.comments;
    }

    public void refreshID(){current_id++;}
    public int getCurrentID(){
        return current_id;
    }
    public void setCurrentID(int a){current_id = a;}

    /**record the comments made by user
     * @return the comment to the course page with user id and comment id
     */
    public ArrayList<ArrayList<String>> recordComments(){
        ArrayList<ArrayList<String>> comments = new ArrayList<>();
        for (Integer id : this.comments.keySet()){
            Comment comment = this.comments.get(id);
            String semester = this.semester;
            String ID = id.toString();
            String author = comment.getAuthor();
            String content = comment.getComment();
            String replyID = Integer.valueOf(comment.getReplyID()).toString();
            String status = comment.getStatus().toString();
            String courseCode = comment.getCourseCode();
            String replyTo = comment.getReplyTo().toString();
            ArrayList<String> currentComment = new ArrayList<>(Arrays.asList(courseCode, semester, ID, author, content, replyID, status, replyTo));
            comments.add(currentComment);



        }
        return comments;
    }
}