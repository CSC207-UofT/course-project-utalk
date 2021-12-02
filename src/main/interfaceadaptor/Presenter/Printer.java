package interfaceadaptor.Presenter;

import entity.Comment;
import entity.CommentableUser;



/**
 * Printer class contains all print function for Commentable User.
 */
public class Printer {
    private final CommentPrinter printer = new CommentPrinter();

    /** Print commentableUser's comments on specific course
     * @param course the name of the course
     * @param commentableUser the commentableUser
     */
    public void commentableUserCommentPresenter(String course, CommentableUser commentableUser) {
        if (commentableUser.getCourseComments(course) != null) {
            for (Comment comment : commentableUser.getCourseComments(course)) {
                CommentPrinter print = new CommentPrinter();
                print.commentPrinter(comment, 0);
            }
        }
    }
    /** Print commentableUser's courses list.
     * @param commentableUser the commentableUser
     */
    public void commentableUserCourseListPresenter(CommentableUser commentableUser) {
            for (String course : commentableUser.getCourseList()) {
                System.out.print(course);
            }
    }
}
