import java.util.ArrayList;
import java.util.HashMap;

public class CoursePage {
    private Course course;
    private ArrayList<Professor> professor_list;
    private ArrayList<Student> student_list;
    private HashMap<String, PostPage> post_page_List;

    CoursePage(Course course) {
        this.course = course;
        this.professor_list = new ArrayList<>();
        this.student_list = new ArrayList<>();
        this.post_page_List= new HashMap<String, PostPage>();
        PostPage pp = new PostPage(course.course_start_year);
        this.post_page_List.put(course.course_start_year, pp);
    }
    public PostPage getPostPage(String semester){
        return this.post_page_List.get(semester);
    }

}