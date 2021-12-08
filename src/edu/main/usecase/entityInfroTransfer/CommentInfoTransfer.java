package usecase.entityInfroTransfer;

import entity.Comment;

import java.util.HashMap;

/**
 * Transfer comment information to outerlayer
 */
public class CommentInfoTransfer {
    public static HashMap<String, String> getInfo(Comment comment) {
        HashMap<String, String> mp = new HashMap<>();
        mp.put("Id", String.valueOf(comment.getId()));
        mp.put("Author", comment.getAuthor());
        mp.put("content", comment.getComment());
        return mp;
    }

    /**
     * @param comment comment
     * @return comment status
     */
    public static Boolean getStatus(Comment comment) {
        return comment.getStatus();
    }

    /**
     * @param comment comment
     * @return true if comment exists replies, false otherwise
     */
    public static Boolean existsReply(Comment comment) {
        return comment.existReply();
    }

    /**
     * @param comment comment
     * @return replies of comments
     */
    public static HashMap<Integer, Comment> getReplies(Comment comment) {
        return comment.getReplies();
    }

}
