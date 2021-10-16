import java.util.ArrayList;

public class CoursePage {
    private Course course;
    private ArrayList<Professor> professor_list;
    private ArrayList<Student> student_list;
    private ArrayList<PostPage> post_page_List;

    CoursePage(Course course, ArrayList<Professor> professor_list) {
        this.course = course;
        this.professor_list = professor_list;
        this.student_list = new ArrayList<>();
        this.post_page_List = new PostPage(course);

    }
}
