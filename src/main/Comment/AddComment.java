package Comment;

import basics.Comment;
import AddCourse.PostPage;

/**
 * Interface for adding comments
 * Returns true if the comment has been added successfully
 * Returns false otherwise
 */
public interface AddComment{
     boolean addComment(String semester, PostPage pp, Comment c);
     boolean addComment(String semester, PostPage pp, Comment c, Comment reply);
}