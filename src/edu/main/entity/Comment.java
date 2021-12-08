package entity;

import java.util.HashMap;

public class Comment {
    private final Integer id;
    private final String author;
    private String comment;
    private HashMap<Integer, Comment> replies;
    private Integer replyID;
    private boolean status;
    private final String course_code;
    private final Integer replyTo;

    public Comment(String username, String comment, String course_code, Integer replyTo, Integer id) {
        this.author = username;
        this.comment = comment;
        this.course_code = course_code;
        this.id = id;
        this.replies = new HashMap<>();
        this.replyID = 1;
        this.status = true;
        this.replyTo = replyTo;

    }

    public String getComment() {
        return this.comment;
    }
    public String getCourseCode() {
        return this.course_code;
    }
    public Integer getReplyTo() {
        return this.replyTo;
    }

    public void deleteCommentSetter() {this.status = false;}

    public void editComment(String edit) {
        this.comment = edit;
    }
    public void setReplyID(int i) {
        this.replyID = i;
    }

    public void setStatus(boolean a){
        this.status = a;
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


    /**reply to the comment which have that specific index
     * @param index the index of comment
     * @return comment with this index
     */
    public Comment getReply(int index) {
        if (hasReply(index)) {
            return this.replies.get(index);
        }
        return null;
    }
    public Integer getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public boolean existReply() {
        return this.replyID != 1;
    }

    public int getReplyID() {
        return this.replyID;
    }

    public HashMap<Integer, Comment> getReplies() {
        return this.replies;
    }
}

