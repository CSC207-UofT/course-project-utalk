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
    /**reply to the comment which have that specific index
     * @param index the index of comment
     * @return
     */
    public Comment getReply(int index, Comment comment) {
        return comment.getReply(index);
    }
    public Boolean getStatus(Comment comment) {
        return comment.getStatus();
    }

}
