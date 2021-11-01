package AddCourse;

import basics.Course;
import basics.Professor;
import basics.Student;

import java.util.ArrayList;

public class CoursePage {
    public final Course course;
    public String info_added;
    private ArrayList<Professor> professor_list;
    private ArrayList<Student> student_list;
    public ArrayList<PostPage> post_page_List;

    public CoursePage(Course course) {
        this.course = course;
        this.professor_list = new ArrayList<>();
        this.student_list = new ArrayList<>();
        this.info_added = "";
        ArrayList<PostPage> post_lst = new ArrayList<>();
        post_lst.add(new PostPage(course.course_start_year));
        this.post_page_List = post_lst;
    }
}
