package AddCourse;

import basics.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PostPage {
    public Map<Integer, Comment> comments ;
    public ArrayList<Comment> posts;



    String semester;
    public int current_id;

    PostPage(String semester_1) {
        this.comments = new HashMap<>();
        posts = new ArrayList<>();
        semester = semester_1;
        current_id = 0;

    }
    void Print_comments(){
        for(Comment comment : posts){
            comment.Print_Comment(0);
        }
    }
}