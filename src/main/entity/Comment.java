package entity;

import java.util.HashMap;
import java.util.UUID;

public class Comment {
    private final String id;
    private final String author;
    private String comment;
    private HashMap<Integer, Comment> replies;
    private int replyID;
    private boolean status;

    Comment(String username, String comment) {
        this.author = username;
        this.comment = comment;
        this.id = UUID.randomUUID().toString();
        this.replies = new HashMap<>();
        this.replyID = 1;
        this.status = true;
    }

    public String getComment() {
        return this.comment;
    }

    public void editComment(String edit) {
        this.comment = edit;
    }

    /** Add comment c into replies, increase replyID by 1.
     * @param c the comment that will be added to replies
     */
    public void addReply(Comment c) {
        this.replies.put(this.replyID, c);
        this.replyID += 1;
    }

    public boolean hasReply(int index) {
        return this.replies.containsKey(index);
    }

    public Comment getReply(int index) {
        if (hasReply(index)) {
            return this.replies.get(index);
        }
        return null;
    }

    public String getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void changeStatus() {
        status = !status;
    }

    public boolean existReply() {
        return this.replyID != 1;
    }

    public int getReplyID() {
        return this.replyID;
    }
}

