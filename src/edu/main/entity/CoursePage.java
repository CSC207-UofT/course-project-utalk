package entity;

import java.util.ArrayList;

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
        this.info_added = "This semester we will go online";
        ArrayList<PostPage> post_lst = new ArrayList<>();
        post_lst.add(new PostPage(course.course_start_year));
        this.post_page_List = post_lst;
    }

    public ArrayList<String> studentList() {
        ArrayList<String> std_lst = new ArrayList<>();
        for (Student std: student_list) {
            if (! std_lst.contains(std.getUserName())) {
                std_lst.add(std.getUserName());
            }
        }
        return std_lst;
    }
    public ArrayList<String> professorList() {
        ArrayList<String> prof_lst = new ArrayList<>();
        for (Professor professor: professor_list) {
            if (! prof_lst.contains(professor.getUserName())) {
                prof_lst.add(professor.getUserName());
            }
        }
        return prof_lst;
    }

    public PostPage getPostPage(int id) {
        return this.post_page_List.get(id);
    }

    public int getLength(){
        return post_page_List.size();
    }


    public ArrayList<PostPage> getPost_page_List(){
        return this.post_page_List;
    }
}
