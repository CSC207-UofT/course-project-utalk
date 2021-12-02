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
    static final String file_name = "D:\\2021Fall\\CSC207\\IdeaProjects\\course-project-utalk\\src\\main\\outerlayer\\database\\comment data.txt";

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
        pagePrinter(postPage);
        recordAndPresent.recordAndPresent("\n", file_name);
    }

    /** Print all comments in postPage
     * @param postPage the postPage that will be printed
     */
    public void pagePrinter(PostPage postPage) {
        for (Comment comment : postPage.posts) {
            commentPrinter(comment, 0);
        }
        recordAndPresent.recordAndPresent("\n", file_name);
    }
}
