package main.entity;

import java.util.HashMap;
import java.util.UUID;

public class Comment {
    private final String id;
    private final CommentableUser author;
    private String comment;
    private HashMap<Integer, Comment> replies;
    private int replyID;

    public Comment(CommentableUser user, String comment) {
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

    public boolean hasReply(int index) {
        return this.replies.containsKey(index);
    }

    public Comment getReply(int index) {
        if (hasReply(index)){
        return this.replies.get(index);
        }
        return null;
    }

    public HashMap<Integer, Comment> getReplies() {
        return this.replies;
    }

    public String getId(){
        return this.id;
    }

    public CommentableUser getAuthor(){
        return this.author;
    }

}

