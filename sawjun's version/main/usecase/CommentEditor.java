package main.usecase;

import main.entity.*;

public class CommentEditor {
    private final CommentableUser cu;

    public CommentEditor(CommentableUser cu){
        this.cu = cu;
    }

    /**
     * Output of all methods related to editing comments
     */
    public enum EditCommentStatus {
        EDITED,
        CANNOT_EDIT,
    }

    /**
     * Method for editing comments in the outermost layer of the main.entity.PostPage comments
     * @param coursePageMap a map that stores all existing CoursePages
     * @param courseName the course name of the main.entity.Course
     * @param index the position of the comment
     * @param edit the edit inputted by the user
     * @return
     * - CANNOT_EDIT if the user does not have permission to edit
     * - EDITED if the comment has been edited successfully
     */
    public EditCommentStatus editComment(CoursePageMap coursePageMap, String courseName, int index, String edit) {
        //Assuming the main.entity.PostPage has this index and this is checked by user interface/input layer
        CoursePage cp = coursePageMap.getMap().get(courseName);
        PostPage pp = cp.getPostPage(cp.getLength() - 1);
        //Assuming here that there is no edit comment option for past PostPages
        Comment comment = pp.getCommentList().get(index);
        String key = courseName + " " + pp.getSemester();
        if (this.cu.canEditComment(key, comment)){
            comment.editComment(edit);
            return EditCommentStatus.EDITED;
        }
        return EditCommentStatus.CANNOT_EDIT;
    }

    /**
     * Method for editing comments in inner layers of the main.entity.PostPage comments
     * @param coursePageMap a map that stores all existing CoursePages
     * @param courseName the coursename of the main.entity.Course
     * @param comment the outer comment the to be edited comment is within
     * @param index the index of the to be edited comment
     * @param edit the edit inputted by the user
     * @return
     *      * - CANNOT_EDIT if the user does not have permission to edit
     *      * - EDITED if the comment has been edited successfully
     */
    public EditCommentStatus editInnerComment(CoursePageMap coursePageMap, String courseName, Comment comment, int index, String edit){
        //Assuming comment is given by the input/interface layer and index exists
        CoursePage cp = coursePageMap.getMap().get(courseName);
        PostPage pp = cp.getPostPage(cp.getLength() - 1);
        String key = courseName + " " + pp.getSemester();
        Comment c = comment.getReply(index);
        if (this.cu.canEditComment(key, c)){
            c.editComment(edit);
            return EditCommentStatus.EDITED;
        }
        return EditCommentStatus.CANNOT_EDIT;
    }
}
