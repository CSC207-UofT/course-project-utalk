package interface_adaptor.Presenter;

import entity.PostPage;
import entity.Comment;

public class PostPagePrinter {
    public void PagePrinter(PostPage postPage) {
        CommentPrint printer = new CommentPrint();
        for (Comment comment : postPage.posts) {
            printer.CommentPrinter(comment, 0);
        }
    }
}
