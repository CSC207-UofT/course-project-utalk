package usecase.adddeleteeditcomment;

import entity.CommentableUser;
import entity.CoursePage;
import entity.PostPage;
import entity.Professor;
import usecase.javastorage.AllCourses;

public class CommentDeleter {

    /**
     * delete comment for student
     * @param user user making the comment
     * @param course_code the course code of
     * @param comment_id the comment id of comment to delete
     * @return return the string indicate whether successfully delete
     */
    public static String deleteComment(CommentableUser user, String course_code, int comment_id){
        if (CanChange.canAccessComment(course_code, comment_id, user)){
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.comments.get(comment_id).deleteCommentSetter();
            return "Comment has been deleted.";

        }
        else{
            return "Sorry, you can not delete that comment.";
        }
    }

    /**
     * delete comment function for professor
     * @param user professor
     * @param course_code course code of comment
     * @param comment_id id of the comment
     * @return return the string indicate whether successfully delete
     */

    public static String deleteCommentProf(Professor user, String course_code, int comment_id){
        if (CanChange.canDeleteComment(course_code, comment_id, user)){
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.comments.get(comment_id).deleteCommentSetter();
            return "Comment has been deleted.";
        }
        else{
            return "Sorry, you can not delete that comment.";

        }
    }
}
