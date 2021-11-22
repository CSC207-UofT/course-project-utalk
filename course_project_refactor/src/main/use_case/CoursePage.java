package use_case;

import entity.Course;

import java.util.ArrayList;
import java.util.Map;

public class CoursePage {
    public final Course course;
    public String info_added;
    public ArrayList<Professor> professor_list;
    public ArrayList<Student> student_list;
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

    public void page_presenter() {
        Map<String, Object> info_map = this.course.course_info();
        System.out.println("Course: " + info_map.get("code") + "\n" + "Year: " + info_map.get("year"));
        System.out.println("======================================================================\n");
        System.out.println("Professor(s): \n");
        for (Professor prof: this.professor_list) {
            System.out.println(prof.getUserName() + ", ");
        }
        System.out.println("""

                Course Information:
                """);
        System.out.println(info_map.get("description") + "\n");
        System.out.println(this.info_added);
    }
    public void comment_presenter() {
        for(PostPage page: this.post_page_List){
            page.Print_comments();
        }
    }
}