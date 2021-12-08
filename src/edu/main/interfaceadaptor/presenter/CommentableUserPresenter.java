package interfaceadaptor.presenter;

import entity.Comment;
import entity.CommentableUser;
import usecase.entityInfroTransfer.CommentableUserInfoTransfer;


/**
 * CommentableUserPresenter class contains all print function for Commentable User.
 */
public class CommentableUserPresenter implements GeneralPrinter {
    /**
     * Print commentableUser's courses list.
     *
     * @param commentableUser the commentableUser
     */
    public static void commentableUserCourseListPresenter(CommentableUser commentableUser) {

        if (CommentableUserInfoTransfer.getCourseList(commentableUser).size() == 0) {
            System.out.println("Please first enroll the course");
        } else {
            System.out.println("This is all the courses you have enrolled.");
            for (String course : CommentableUserInfoTransfer.getCourseList(commentableUser)) {
                System.out.print(course);
            }
        }
    }

    /**
     * Print commentableUser's comments on specific course
     *
     * @param course          the name of the course
     * @param commentableUser the commentableUser
     */
    @Override
    public void presenterRequiresUserInfo(String course, CommentableUser commentableUser) {
        if (commentableUser.getCourseComments(course) != null) {
            for (Comment comment : CommentableUserInfoTransfer.getCourseComment(course, commentableUser)) {
                CommentPrinter.commentPrinterWithoutReply(comment, 0);
            }
        } else {
            System.out.println("Please first enroll the course.");
        }

    }

    @Override
    public void generalPresenter(String course) {
    }
}
