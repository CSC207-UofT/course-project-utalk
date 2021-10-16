import java.util.ArrayList;

public class Student extends User{
    private ArrayList<Comment> student_comments;
    private ArrayList<CoursePage> student_course;
    // Do we need to restate the instance attribute for student?
    Student(int student_number, String student_name, String password){
        super(student_number, student_name, password);
        student_comments = new ArrayList<>();
    }
    void add_course(String course_name){

    }
}
