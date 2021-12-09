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

    /**
     * @return comment content
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @return course code
     */
    public String getCourseCode() {
        return this.course_code;
    }

    /**
     * @return the comment id it is replying to
     */
    public Integer getReplyTo() {
        return this.replyTo;
    }

    /**
     * deleteComment
     */
    public void deleteCommentSetter() {this.status = false;}

    /**
     * change content
     * @param edit new content
     */

    public void editComment(String edit) {
        this.comment = edit;
    }

    /**
     * @param i the replyid
     */
    public void setReplyID(int i) {
        this.replyID = i;
    }

    /**
     * set status
     * @param a the status of comment
     */

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


    /**
     * @return comment id
     */

    public Integer getId() {
        return this.id;
    }

    /**
     * @return author name
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @return status of comment
     */
    public Boolean getStatus() {
        return this.status;
    }

    /**
     * @return whehther the comment have reply
     */
    public boolean existReply() {
        return this.replyID != 1;
    }

    /**
     * @return reply id
     */
    public int getReplyID() {
        return this.replyID;
    }

    /**
     * @return replies
     */

    public HashMap<Integer, Comment> getReplies() {
        return this.replies;
    }
}

