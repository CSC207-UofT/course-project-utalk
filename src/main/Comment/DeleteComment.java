package Comment;

import AddCourse.PostPage;
import basics.Comment;

/**
 * Interface for deleting comments
 * Returns true if the comment has been deleted successfully
 * Returns false otherwise
 */
public interface DeleteComment {
    boolean deleteComment(String semester, PostPage pp, Comment c);
}