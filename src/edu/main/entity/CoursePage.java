package entity;
import java.util.ArrayList;
import java.util.HashMap;

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
            std_lst.add(std.getUserName());
        }
        return std_lst;
    }
    public ArrayList<String> professorList() {
        ArrayList<String> prof_lst = new ArrayList<>();
        for (Professor professor: professor_list) {
            prof_lst.add(professor.getUserName());
        }
        return prof_lst;
    }

    public Boolean isProfessor(String userName){
        ArrayList<String> prof_lst = this.professorList();
        return prof_lst.contains(userName);
    }
    public Boolean isStudent(String userName){
        ArrayList<String> std_lst = this.studentList();
        return std_lst.contains(userName);
    }

    public PostPage getPostPage(String semester) {
        return this.postPageHashMap().get(semester);
    }

    public PostPage getPostPage(int id) {
        return this.post_page_List.get(id);
    }

    public int getLength(){
        return post_page_List.size();
    }


    /**
     * @return A hashmap containing all PostPage information in post_page_List,
     * use semester as the key and PostPage as value
     */
    public HashMap<String, PostPage> postPageHashMap(){
        HashMap<String, PostPage> mp = new HashMap<String, PostPage>();
        for(PostPage pg: post_page_List) {
            mp.put(pg.semesterGetter(), pg);
        }
        return mp;
    }
    /**
     * @return A list of string containing all semesters of PostPages in post_page_List,
     */
    public ArrayList<String> semesterList(){
        ArrayList<String> lst = new ArrayList<>();
        for(PostPage pg: post_page_List) {
            if (! lst.contains(pg.semesterGetter())) {
                lst.add(pg.semesterGetter());
            }
        }
        return lst;
    }
    public ArrayList<PostPage> getPost_page_List(){
        return this.post_page_List;
    }
}
