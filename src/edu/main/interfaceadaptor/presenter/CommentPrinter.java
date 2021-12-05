package interfaceadaptor.presenter;

import entity.Comment;
import interfaceadaptor.gateways.TextFileCreator;

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
            RecordAndPresent.recordAndPresent(" ".repeat(indentation) + comments.getId() + ". " + comments.getAuthor() + " posted: " + comments.getComment(), file_name);
            if (comments.existReply()) {
                for (int id = 1; id < comments.getReplyID(); id++) {
                    Comment comment = comments.getReply(id);
                    RecordAndPresent.recordAndPresent("\n" + " ".repeat(indentation + 1) + comments.getId() + ". " + comment.getAuthor() + " replied: " + comment.getComment(), file_name);
                }
            }
        }
        RecordAndPresent.recordAndPresent("\n", file_name);
    }

}
