package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;
import AddCourse.PostPage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends User implements Add_Comment,Delete_Comment{
    private String user_name;
    Professor(String identifier, String user_name, String password){
        super(identifier, user_name, password);
        ArrayList<Course> taught_courses = new ArrayList<>();
    }

    @Override
    public void add_comment(String content, LocalDate time, String Course_code) {
        Comment comment = new Comment(user_name, content, time, Course_code);
        CoursePage coursepage = AllCourses.linked_page.get(Course_code);
        coursepage.post_page_List.get(-1).comments.put(comment.id, comment);


    }

    public void add_comment(String content, LocalDate time, String Course_code, int reply_to_id) {
        Comment comment = new Comment(user_name, content, time, Course_code);
        CoursePage coursepage = AllCourses.linked_page.get(Course_code);
        coursepage.post_page_List.get(-1).comments.get(reply_to_id).replies.add(comment);
    }
    @Override
    public String delete_comment(int comment_id, String course_code){
        CoursePage coursepage = AllCourses.linked_page.get(course_code);
        if(!coursepage.professor_list.contains(this)){
            return "you are not professor of this course";}
        else{
            PostPage postpage = coursepage.post_page_List.get(-1);
            if (comment_id > postpage.current_id){
                return "wrong id";
            }
            else{
                postpage.comments.get(comment_id).status = false;
                return "delete successfully";
            }
        }

    }
}