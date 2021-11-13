
package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;
import AddCourse.PostPage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;

public class Student extends CommentableUser{
    private ArrayList<String> student_course;
    private String password;
    private HashMap<String, ArrayList<Comment>> student_comments = new HashMap<>();

    // Do we need to restate the instance attribute for student?
    public Student(String student_name, String identifier, String password) {
        super(student_name, identifier, password);
        this.password = password;
        HashMap<String, ArrayList<Comment>> student_comments= new HashMap<>();
        ArrayList<String> student_course = new ArrayList<>();
    }

    public void enroll_course(String course_code) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
        student_course.add(course_code);
        coursepage.student_list.add(this);
        ArrayList<Comment> comments = new ArrayList<>();
        student_comments.put(course_code, comments);
    }

    public void delete_course(String course_code) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
        student_course.remove(coursepage);
        coursepage.student_list.remove(this);

    }


    public boolean passwordMatches(String password) {
        return password.equals(this.password);
    }
    @Override
    public void user_comment(String course) {
        for(Comment comment: this.student_comments.get(course)) {
            comment.Print_Comment(0);
        }
    }
}
