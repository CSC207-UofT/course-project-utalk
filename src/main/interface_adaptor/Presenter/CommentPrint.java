package interface_adaptor.Presenter;

import entity.Comment;

public class CommentPrint {
    public void CommentPrinter(Comment comments, int indentation){
        if (comments.getStatus()) {
            System.out.println(" ".repeat(indentation)  + comments.getAuthor() + "posted:" + "\n");
            System.out.println(" ".repeat(indentation + 1) + comments.getId() + comments.getComment()+ "\n" );
        }
        if (comments.existReply()) {
            for (int id = 1; id < comments.getReplyID(); id++) {
                Comment comment = comments.getReply(id);
                System.out.println(" ".repeat(indentation + 2) + comments.getAuthor()+ "replied:" + "\n");
                CommentPrinter(comment, indentation + 3);
            }
        }

    }

}
