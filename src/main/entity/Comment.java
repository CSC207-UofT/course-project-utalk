package entity;
import java.util.HashMap;
import java.util.UUID;

public class Comment {
    private final String id;
    private final CommentableUser author;
    private String comment;
    private HashMap<Integer, Comment> replies;
    private int replyID;

    Comment(CommentableUser user, String comment) {
        this.author = user;
        this.comment = comment;
        this.id = UUID.randomUUID().toString();
        this.replies = new HashMap<>();
        this.replyID = 1;
    }

    public String getComment(){
        return this.comment;
    }

    public void editComment(String edit){
        this.comment = edit;
    }

    public void addReply(Comment c){
        this.replies.put(this.replyID, c);
        this.replyID += 1;
    }
    public HashMap<Integer, Comment> getReplies() {
        return this.replies;
    }

    public CommentableUser getAuthor(){
        return this.author;
    }

    //feel free to add appropriate getters/simple boolean methods where required

}