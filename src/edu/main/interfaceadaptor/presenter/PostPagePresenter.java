package interfaceadaptor.presenter;

import entity.Comment;
import entity.PostPage;
import usecase.entityInfroTransfer.PostContentGenerator;
import static outerlayer.userinterface.FilePathHelper.FILEPATH;

public class PostPagePresenter {
    public static final String file_name = FILEPATH + "course page data.txt";

    /**
     * Print all comments in postPage
     *
     * @param postPage the postPage that will be printed
     */
    public static void pagePrinter(PostPage postPage) {
        for (Comment comment : PostContentGenerator.commentTransfer(postPage)) {
            CommentPrinter.commentPrinter(comment, 0);
        }
        RecordAndPresent.recordAndPresent("\n", file_name);
    }
}
