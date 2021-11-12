package AddCourse;

import basics.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostPage {
    public Map<Integer, Comment> comments ;


    String semester;
    public int current_id;

    PostPage(String semester_1) {
        this.comments = new HashMap<>();
        semester = semester_1;
        current_id = 0;

    }
}
