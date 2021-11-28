package interfaceadaptor.Presenter;

import entity.Comment;
import entity.CoursePage;
import entity.PostPage;
import usecase.javastorage.AllCourses;

/**
 * CommentPrint prints comment object reasonably
 */
public class CommentPrinter {
    /** Print the comment in a readable way
     * @param comments the comment that will be printed
     * @param indentation the number of indentation
     */
    public void CommentPrinter(Comment comments, int indentation){
        if (comments.getStatus()) {
            System.out.println(" ".repeat(indentation)  + comments.getAuthor() + "posted:" + "\n");
            System.out.println(" ".repeat(indentation + 1) + comments.getId() + comments.getComment()+ "\n" );
        }
        if (comments.existReply()) {
            for (int id = 1; id < comments.getReplyID(); id++) {
                Comment comment = comments.getReply(id);
                System.out.println(" ".repeat(indentation + 2) + comment.getAuthor()+ "replied:" + "\n");
                System.out.println(" ".repeat(indentation + 3) + comment.getId() + comment.getComment()+ "\n" );
            }
        }
    }

    /** Print the course comment
     * @param course the course that will be printed
     */
    public void courseCommentPresenter(String course) {
        CoursePage cour = AllCourses.coursePageHashMap.get(course);
        PostPage postPage = cour.post_page_List.get(-1);
        pagePrinter(postPage);
    }

    /** Print all comments in postPage
     * @param postPage the postPage that will be printed
     */
    public void pagePrinter(PostPage postPage) {
        for (Comment comment : postPage.posts) {
            CommentPrinter(comment, 0);
        }
    }
}
