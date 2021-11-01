import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends User{
    private ArrayList<Course> taught_courses;
    private HashMap<Integer, Comment> comments;
    Professor(String identifier, String user_name, String password){
        super(identifier, user_name, password);
        this.taught_courses = new ArrayList<>();
        this.comments = new HashMap<>();
    }
    public void addComment(Course course, String semester, Comment comment){
        this.comments.put(comment.id, comment);
        if (taught_courses.contains(course)){
            CoursePage cp = AllCourses.linked_page.get(course);
            PostPage pp = cp.getPostPage(course.course_start_year);
            pp.comment_list.add(comment);
        }
    }
}