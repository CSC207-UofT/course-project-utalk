package interfaceadaptor.Presenter;

import entity.Comment;
import entity.PostPage;

public class PostPagePresenter {
    public final String file_name = "course page data.txt";
    /** Print all comments in postPage
     * @param postPage the postPage that will be printed
     */
    public void pagePrinter(PostPage postPage) {
        for (Comment comment : postPage.posts) {
            CommentPrinter cp = new CommentPrinter();
            cp.commentPrinter(comment, 0);
        }
        RecordAndPresent recordAndPresent = new RecordAndPresent();
        recordAndPresent.recordAndPresent("\n", file_name);
    }
}
