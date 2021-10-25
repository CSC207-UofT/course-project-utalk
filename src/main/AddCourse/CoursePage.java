package AddCourse;

import basics.Course;
import basics.Professor;
import basics.Student;

import java.util.ArrayList;

public class CoursePage {
    private Course course;
    private ArrayList<Professor> professor_list;
    private ArrayList<Student> student_list;
    private ArrayList<PostPage> post_page_List;

    CoursePage(Course course) {
        this.course = course;
        this.professor_list = new ArrayList<>();
        this.student_list = new ArrayList<>();
        ArrayList<PostPage> post_lst = new ArrayList<>();
        post_lst.add(new PostPage(course.course_start_year));
        this.post_page_List = post_lst;
    }
}
