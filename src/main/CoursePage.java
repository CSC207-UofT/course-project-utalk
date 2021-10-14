import java.util.ArrayList;

public class CoursePage {
    String course_info;
    ArrayList<Professor> professor_list;
    ArrayList<Student> student_list;
    ArrayList<PostPage> post_page_List;

    CoursePage(String course_info) {
        this.course_info = course_info;
    }
}
