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
        this.commentableUser.addCourseComments(courseCode);
        this.commentableUser.getCourseComments(courseCode).add(comment);


    }

    public void addComment(String content, LocalDate time, String courseCode, int replyToId) {
        Comment comment = new Comment(this.commentableUser.getUserName(), content, time, courseCode);
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        PostPage postpage = coursepage.post_page_List.get(coursepage.post_page_List.size() - 1);
        postpage.comments.get(replyToId).replies.add(comment);
        this.commentableUser.addCourseComments(courseCode);
        this.commentableUser.getCourseComments(courseCode).add(comment);
    }

}
