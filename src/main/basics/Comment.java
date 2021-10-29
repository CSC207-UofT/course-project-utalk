package basics;

import java.util.ArrayList;

public class Comment {
    static int comment_id;
    int id;
    int student_id;
    String comment;
    ArrayList<Comment> replies;
    Comment(int student_id, String comment) {
        this.student_id = student_id;
        this.comment = comment;
        comment_id += 1;
        this.id = comment_id;
    }
}