package usecase.entityInfroTransfer;

import entity.Comment;

import java.util.HashMap;

public class CommentInfoTransfer {
    public static HashMap<String, String> getInfo(Comment comment) {
        HashMap<String, String> mp = new HashMap<>();
        mp.put("Id", String.valueOf(comment.getId()));
        mp.put("Author", comment.getAuthor());
        mp.put("content", comment.getComment());
        return mp;
    }
    public static int getReplyID(Comment comment) {
        return comment.getReplyID();
    }
    /**reply to the comment which have that specific index
     * @param index the index of comment
     * @return
     */
    public static Comment getReply(int index, Comment comment) {
        return comment.getReply(index);
    }
    public static Boolean getStatus(Comment comment) {
        return comment.getStatus();
    }

}
