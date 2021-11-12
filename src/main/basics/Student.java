
package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;

import java.util.ArrayList;
import java.time.LocalDate;

public class Student extends User implements Add_Comment,Delete_Comment,Edit_Comment {
    private ArrayList<CoursePage> student_course;
    private final String password;

    // Do we need to restate the instance attribute for student?
    public Student(String student_name, String identifier, String password) {
        super(student_name, identifier, password);
        this.password = password;
        ArrayList<Comment> student_comments = new ArrayList<>();
    }

    public boolean passwordMatches(String password) {
        return password.equals(this.password);
    }

    @Override
    public String edit_comment(String new_content, int comment_id, String course_code) {
        CoursePage coursepage = AllCourses.linked_page.get(course_code);
        Comment comment = coursepage.post_page_List.get(-1).comments.get(comment_id);
        if (comment.user_name.equals(user_name) & comment.status) {
            comment.content = new_content;
            return "edid successfully";
        } else {
            return "you can not edit this comment";
        }

    }

    @Override
    public String delete_comment(int comment_id, String course_code) {
        CoursePage coursepage = AllCourses.linked_page.get(course_code);
        Comment comment = coursepage.post_page_List.get(-1).comments.get(comment_id);
        if (comment.user_name.equals(user_name)) {
            comment.status = false;
            return "delete successfully";
        } else {
            return "you can not delete this comment";
        }
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

    void add_course(String course_name) {

    }

}

