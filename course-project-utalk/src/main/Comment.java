import java.util.ArrayList;

public class Comment {
    int comment_id;
    int student_id;
    String comment;
    ArrayList<Comment> replies;
    Comment(int student_id, String comment) {
        this.student_id = student_id;
        this.comment = comment;
        this.comment_id += 1;
    }
}
