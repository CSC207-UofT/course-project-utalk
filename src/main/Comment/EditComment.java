package Comment;

import AddCourse.PostPage;
import basics.Comment;

/**
 * Interface for editing comments
 * Returns true if the comment has been edited successfully
 * Returns false otherwise
 */
public interface EditComment {
    boolean editComment(PostPage pp, Comment c, String edit);
}