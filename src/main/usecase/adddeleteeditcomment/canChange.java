package usecase.adddeleteeditcomment;
import entity.*;
import usecase.javastorage.AllCourses;
public class canChange {

    public static boolean canAddComment(String course_code, Integer reply_to, CommentableUser user){


        if (! user.getCourseList().contains(course_code)){
            System.out.println("not enrolled");
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
    public static boolean canDeleteComment(String course_code, int comment_id, Professor user){
        if(! user.getCourseList().contains(course_code)){
            return false;
        }
        int length = AllCourses.coursePageHashMap.get(course_code).getLength();
        PostPage postpage = AllCourses.coursePageHashMap.get(course_code).getPostPage(length-1);
        return postpage.current_id >= comment_id;

    }

}
