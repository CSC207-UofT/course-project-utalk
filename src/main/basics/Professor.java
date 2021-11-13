package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;
import AddCourse.PostPage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends CommentableUser{

    private ArrayList<CoursePage> taught_courses;
    private HashMap<String, ArrayList<Comment>> comments = new HashMap<>();


    Professor(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
        HashMap<String, ArrayList<Comment>> comments= new HashMap<>();
        ArrayList<CoursePage> taught_courses = new ArrayList<>();
    }

    public void enroll_course(String course_code) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
        taught_courses.add(coursepage);
        coursepage.professor_list.add(this);
        ArrayList<Comment> comment = new ArrayList<>();
        comments.put(course_code, comment);
    }

    public void delete_course(String course_code) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
        taught_courses.remove(coursepage);
        coursepage.professor_list.remove(this);

    }
    @Override
    public void user_comment(String course) {
        for(Comment comment: this.comments.get(course)) {
            comment.Print_Comment(0);
        }
    }
}