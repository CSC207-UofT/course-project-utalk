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
    public static Boolean getStatus(Comment comment) {
        return comment.getStatus();
    }
    public static Boolean existsReply(Comment comment) {
        return comment.existReply();
    }
    public static HashMap<Integer, Comment> getReplies(Comment comment) {
        return comment.getReplies();
    }

}
