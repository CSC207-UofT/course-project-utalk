package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;

public class CommentEditor {
    CommentableUser commentableUser;

    public CommentEditor(CommentableUser commentableUser){
        this.commentableUser = commentableUser;
    }

    public String editComment(String newContent, int commentId, String courseCode) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        Comment comment = coursepage.post_page_List.get(-1).comments.get(commentId);
        if (comment.user_name.equals(this.commentableUser.getUserName()) & comment.status) {
            comment.content = newContent;
            return "Edited successfully";
        } else {
            return "You can not edit this comment";
        }

    }
}
