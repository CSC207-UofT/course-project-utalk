package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;
import AddCourse.PostPage;

import java.time.LocalDate;

public class CommentAdder{
    CommentableUser commentableUser;

    public CommentAdder(CommentableUser commentableUser){
        this.commentableUser = commentableUser;
    }

    public void addComment(String content, LocalDate time, String courseCode) {
        Comment comment = new Comment(this.commentableUser.getUserName(), content, time, courseCode);
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        int index = coursepage.post_page_List.size();
        PostPage postpage = coursepage.post_page_List.get(index - 1);
        postpage.comments.put(comment.id, comment);
        postpage.posts.add(comment);
        this.commentableUser.comments.get(courseCode).add(comment);


    }

    public void addComment(String content, LocalDate time, String courseCode, int reply_to_id) {
        Comment comment = new Comment(this.commentableUser.getUserName(), content, time, courseCode);
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        coursepage.post_page_List.get(-1).comments.get(reply_to_id).replies.add(comment);
        this.commentableUser.comments.get(courseCode).add(comment);
    }

}
