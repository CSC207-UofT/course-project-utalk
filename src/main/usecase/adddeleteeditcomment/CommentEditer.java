package usecase.adddeleteeditcomment;

import entity.CommentableUser;
import entity.CoursePage;
import entity.PostPage;
import usecase.javastorage.AllCourses;
import entity.Professor;

public class CommentEditer {

    public void editComment(CommentableUser user, String course_code, int comment_id, String content){
        if (user.canAccessComment(course_code, comment_id)){
            System.out.println("can not edit!");
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.comments.get(comment_id).editComment(content);
            System.out.println("succeed");
        }
        else{
            System.out.println("can not edit!");
        }
    }


}
