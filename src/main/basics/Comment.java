package basics;
import AddCourse.AllCourses;
import AddCourse.PostPage;
import java.util.ArrayList;import java.time.LocalDate;
public class Comment {
    boolean status;
    int id;
    String user_name;
    String comment;
    LocalDate time;
    String course_code;
    ArrayList<Comment> replies;
    Comment(String user_name, String comment, LocalDate time, String course_code) {

        this.user_name = user_name;
        this.comment = comment;
        this.time = time;
        PostPage postpage = AllCourses.linked_page.get(course_code).post_page_List.get(-1);
        postpage.current_id += 1;
        this.id = postpage.current_id;
        this.status = true;
        replies = new ArrayList<>();
    }
}