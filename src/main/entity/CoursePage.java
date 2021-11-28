package entity;
import java.util.ArrayList;
import java.util.HashSet;

public class CoursePage {
    private final Course course;
    private ArrayList<PostPage> postPageList;
    private HashSet<String> students;
    private HashSet<String> professors;

    public CoursePage(Course course) {
        this.course = course;
        this.postPageList = new ArrayList<>();
        this.professors = new HashSet<>();
        this.students = new HashSet<>();
    }
        public PostPage getPostPage(int index){
            return this.postPageList.get(index);
        }

        public int getLength(){
            return this.postPageList.size();
        }

        public boolean isStudent(String username){
        return this.students.contains(username);
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

    public PostPage getPostPage(int id) {
        return post_page_List.get(id);
    }

    public int getLength(){
        return post_page_List.size();
    }

        public boolean isProfessor(String username){
        return this.professors.contains(username);
    }

        public Course getCourse(){return this.course;}

}