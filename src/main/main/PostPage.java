package main;
import java.util.ArrayList;
import java.util.Date;

public class PostPage {
    ArrayList<Comment> comment_list;
    String semester;

    PostPage(String semester_1) {
        this.comment_list = new ArrayList<>();
        semester = semester_1;
    }
}
