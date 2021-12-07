package interfaceadaptor.presenter;

import entity.Comment;
import interfaceadaptor.gateways.TextFileCreator;
import usecase.entityInfroTransfer.CommentInfoTransfer;

import java.util.HashMap;

import static outerlayer.userinterface.FilePathHelper.FILEPATH;

/**
 * CommentPrint prints comment object reasonably
 */
public class CommentPrinter {
    static final TextFileCreator tfc = new TextFileCreator();
    static final String file_name = FILEPATH + "comment data.txt";

    /**
     * Print the comment in a readable way
     *
     * @param comments    the comment that will be printed
     * @param indentation the number of indentation
     */
    public static void commentPrinter(Comment comments, int indentation) {

        tfc.createTextFile(file_name);

        if (comments.getStatus()) {
            HashMap<String, String> mp = CommentInfoTransfer.getInfo(comments);
            RecordAndPresent.recordAndPresent(" ".repeat(indentation) + mp.get("Id")+ ". " + mp.get("Author") + " posted: " + mp.get("content"), file_name);
            if (comments.existReply()) {
                for (int id = 1; id < CommentInfoTransfer.getReplyID(comments); id++) {
                    Comment comment = CommentInfoTransfer.getReply(id, comments);
                    commentPrinter(comment, indentation + 1);
                }
            }
        }
        RecordAndPresent.recordAndPresent("\n", file_name);
    }
}
