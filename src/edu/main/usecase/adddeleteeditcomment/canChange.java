package usecase.adddeleteeditcomment;
import entity.*;
import usecase.javastorage.AllCourses;
public class canChange {

    /**
     *tell whether it is valid to add comment
     * @param course_code the course code of the comment
     * @param reply_to the comment if of the comment to reply
     * @param user user making comment
     *
     */

    public static boolean canAddComment(String course_code, Integer reply_to, CommentableUser user){


        if (! user.getCourseList().contains(course_code)){
            return false;
        }
        if (!reply_to.equals(0)){
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            return postpage.getCurrentID() >= reply_to;
        }
        return true;

    }

    /**
     * tell whether it is valid to edit and for student to delete comment
     * @param course_code the course_code of comment
     * @param comment_id comment id
     * @param user user who want to get access to comment
     *
     */
    public static boolean canAccessComment(String course_code, int comment_id, CommentableUser user) {
        if (user.getCourseList().contains(course_code)) {

            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);

            if (postpage.current_id >= comment_id) {

                return postpage.comments.get(comment_id).getAuthor().equals(user.getUserName());
            }}

        return false;

    }

    /**
     *tell whether a professor can delete specific comment
     * @param course_code course code of the comment
     * @param comment_id id of the comment
     * @param user user making the comment
     */
    public static boolean canDeleteComment(String course_code, int comment_id, Professor user){
        if(! user.getCourseList().contains(course_code)){
            return false;
        }
        int length = AllCourses.coursePageHashMap.get(course_code).getLength();
        PostPage postpage = AllCourses.coursePageHashMap.get(course_code).getPostPage(length-1);
        return postpage.current_id >= comment_id;

    }

}
