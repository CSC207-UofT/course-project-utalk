package usecase.adddeleteeditcomment;

import entity.CommentableUser;
import entity.CoursePage;
import entity.PostPage;
import usecase.javastorage.AllCourses;

public class CommentEditer {

    /**
     * edit someone's own comment
     * @param user user editing comment
     * @param course_code course code of the comment
     * @param content the content of the comment
     * @param comment_id comment id
     * @return return the string indicate whether successfully edit
     */
    public static String editComment(CommentableUser user, String course_code, String content, int comment_id){
        if (CanChange.canAccessComment(course_code, comment_id, user)){
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.comments.get(comment_id).editComment(content);
            return "Your comment has been edited.";
        }
        else{
            return "Sorry, you can not delete that comment.";
        }
    }


}
