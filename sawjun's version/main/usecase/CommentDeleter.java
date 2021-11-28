package main.usecase;

import main.entity.*;

public class CommentDeleter {
    private final CommentableUser cu;

    public CommentDeleter(CommentableUser cu){
        this.cu = cu;
    }

    /**
     * Output of all methods related to deleting comments
     */
    public enum DeleteCommentStatus {
        DELETED,
        CANNOT_DELETE,
    }

    /**
     * Method for deleting comments in the outermost layer of main.entity.PostPage comments
     * @param coursePageMap a map that stores all existing CoursePages
     * @param courseName the name of the course
     * @param index the index of the comment to be deleted
     * @return
     * - DELETED if the comment has been deleted successfully
     * - CANNOT_DELETE if the user cannot delete this comment
     */

    public DeleteCommentStatus deleteComment(CoursePageMap coursePageMap, String courseName, int index) {
        // Assuming this index is valid
        CoursePage cp = coursePageMap.getMap().get(courseName);
        PostPage pp = cp.getPostPage(cp.getLength() - 1);
        String semester = pp.getSemester();
        Comment c = pp.getCommentList().get(index);
        return getDeleteCommentStatus(courseName, semester, c);
    }

    /**
     * Method for deleting comments in inner layers of main.entity.PostPage comments
     * @param coursePageMap a map that stores all existing CoursePages
     * @param courseName the name of the course
     * @param comment the comment that contains the comment to be deleted
     * @param index the index of the commentto be delted
     * @return
     * - DELETED if the comment has been deleted successfully
     * - CANNOT_DELETE if the user cannot delete this comment
     */
    public DeleteCommentStatus deleteInnerComment(CoursePageMap coursePageMap, String courseName, Comment comment, int index) {
        // It is definitely possible to reduce this down to 2 parameters, but it depends on what the interface level gives me
        // Assuming this index is valid
        Comment c = comment.getReply(index);
        CoursePage cp = coursePageMap.getMap().get(courseName);
        PostPage pp = cp.getPostPage(cp.getLength() - 1);
        String semester = pp.getSemester();
        return getDeleteCommentStatus(courseName, semester, c);
    }

    private DeleteCommentStatus getDeleteCommentStatus(String courseName, String semester, Comment c) {
        if (this.cu.canDeleteComment(courseName, semester, c)){
            c.editComment("DELETED");
            CommentableUser user = c.getAuthor();
            String s = courseName + " " + semester;
            user.getComments().get(s).remove(c);
            return DeleteCommentStatus.DELETED;
        }
        return DeleteCommentStatus.CANNOT_DELETE;
    }

}
