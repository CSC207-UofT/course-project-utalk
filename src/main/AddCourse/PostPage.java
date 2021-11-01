package AddCourse;

import basics.Comment;

import java.util.ArrayList;

public class PostPage {
    ArrayList<Comment> comment_list;
    String semester;

    PostPage(String semester_1) {
        this.comment_list = new ArrayList<>();
        semester = semester_1;
    }
}
