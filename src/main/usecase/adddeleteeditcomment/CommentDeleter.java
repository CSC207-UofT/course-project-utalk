package usecase.adddeleteeditcomment;

import entity.CommentableUser;
import entity.CoursePage;
import entity.PostPage;
import entity.Professor;
import usecase.javastorage.AllCourses;

public class CommentDeleter {
    public void deleteComment(CommentableUser user, String course_code, int comment_id){
        if (user.canAccessComment(course_code, comment_id)){
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.comments.get(comment_id).deleteComment();
            System.out.println("succeed");
            System.out.println("can not delete!");
        }
        else{
            System.out.println("can not delete!");
        }
    }

    public void deleteComment(Professor user, String course_code, int comment_id){
        if (user.canDeleteComment(course_code, comment_id)){
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.comments.get(comment_id).deleteComment();
            System.out.println("succeed");
        }
        else{
            System.out.println("can not delete!");

        }
    }
}
