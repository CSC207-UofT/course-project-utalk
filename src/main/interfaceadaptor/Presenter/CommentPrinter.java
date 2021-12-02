package interfaceadaptor.Presenter;

import entity.Comment;
import entity.CoursePage;
import entity.PostPage;
import interfaceadaptor.TextFileCreator;
import usecase.javastorage.AllCourses;

/**
 * CommentPrint prints comment object reasonably
 */
public class CommentPrinter {
    static final TextFileCreator tfc = new TextFileCreator();
    static final RecordAndPresent recordAndPresent = new RecordAndPresent();
    static final String file_name = "comment data.txt";

    /** Print the comment in a readable way
     * @param comments the comment that will be printed
     * @param indentation the number of indentation
     */
    public void commentPrinter(Comment comments, int indentation){

        tfc.createTextFile(file_name);

        if (comments.getStatus()) {
            recordAndPresent.recordAndPresent(" ".repeat(indentation)   + comments.getId() +". "+ comments.getAuthor() + " posted: " + comments.getComment() , file_name);
        }
        if (comments.existReply()) {
            for (int id = 1; id < comments.getReplyID(); id++) {
                Comment comment = comments.getReply(id);
                recordAndPresent.recordAndPresent("\n" + " ".repeat(indentation + 1) + comments.getId() +". "+ comment.getAuthor()+ " replied: " + comment.getComment(), file_name);
            }
        }
        recordAndPresent.recordAndPresent("\n", file_name);
    }

    /** Print the course comment
     * @param course the course that will be printed
     * @param semester the course semester
     */
    public void courseCommentPresenter(String course, String semester) {
        CoursePage cour = AllCourses.coursePageHashMap.get(course);
        PostPage postPage = cour.postPageHashMap().get(semester);
        PostPagePresenter postPagePresenter = new PostPagePresenter();
        postPagePresenter.pagePrinter(postPage);
        recordAndPresent.recordAndPresent("\n", file_name);
    }

}
