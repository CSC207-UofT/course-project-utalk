package use_case;
import entity.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PostPage {
    public Map<Integer, Comment> comments;
    public ArrayList<Comment> posts;


    String semester;
    public int current_id;

    public PostPage(String semester_1) {
        this.comments = new HashMap<>();
        posts = new ArrayList<>();
        semester = semester_1;
        current_id = 0;
    }

    //TODO: add print comment here.
}