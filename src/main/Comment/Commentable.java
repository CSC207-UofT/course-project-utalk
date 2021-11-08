package Comment;

import basics.Comment;
import AddCourse.PostPage;

/**
 * Interface for adding, editing and deleting comments
 */
public interface Commentable {
     boolean addComment(String semester, PostPage pp, Comment c);
     boolean addComment(String semester, PostPage pp, Comment c, Comment reply);
     boolean deleteComment(String semester, PostPage pp, Comment c);
     boolean editComment(String semester, PostPage pp, Comment c, String edit);
}