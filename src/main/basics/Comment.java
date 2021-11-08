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
        this.replies = new ArrayList<>();
    }
    public void editComment(String edit){
        this.comment = edit;
    }

    public void addReply(Comment c){
        this.replies.add(c);
    }

    /**
     * Recursive method for deleting comments
     * @param c the Comment to be deleted
     * @return true if the comment is deleted and false otherwise
     */
    public boolean deleteReply(Comment c) {
        if (this.replies.contains(c)) {
            c.editComment("deleted");
            return true;
        } else {
            for (Comment cmt : this.replies) {
                if (cmt.deleteReply(c)) {
                    return true;
                }
            }
            return false;
        }
    }
}

