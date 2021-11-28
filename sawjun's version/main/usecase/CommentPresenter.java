package main.usecase;

import main.entity.Comment;
import main.entity.Student;

import java.util.HashMap;

public class CommentPresenter{
    private final Comment comment;

    public CommentPresenter(Comment comment){
        this.comment = comment;
    }

    public String getComments(){
        HashMap<Integer, Comment> replies = comment.getReplies();
        if (replies.isEmpty()){
            return "";
        }
        int start = 1;
        int end = replies.keySet().size();
        StringBuilder result = new StringBuilder("Comment: " + this.comment.getComment());
        while (start !=(end + 1)){
            String c = this.comment.getReply(start).getComment();
            String a = this.comment.getReply(start).getAuthor().getUsername();
            result.append("\n").append(start).append(" - ").append("Comment: ").append(c).append(" Username:").append(a);
            start += 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Student s = new Student("student", "password");
        Comment c = new Comment(s, "hello");
        Comment b = new Comment(s, "hi");
        c.addReply(b);
        c.addReply(c);
        CommentPresenter cp = new CommentPresenter(c);
        System.out.println(cp.getComments());
    }
}
