package basics;

import AddCourse.CoursePage;

import java.util.ArrayList;

public class Student extends User implements AddComment, EditComment{
    private ArrayList<Comment> student_comments;
    private ArrayList<CoursePage> student_course;
    private ArrayList<Course> courses;
    private String identifier;
    private String user_name;
    private String password;
    // Do we need to restate the instance attribute for student?
    public Student(String student_name, String identifier, String password){
        super(student_name, identifier, password);
        this.password = password;
        student_comments = new ArrayList<>();
    }
    void add_course(String course_name){
    }


    //    @Override
//    public String toString(){
//        return identifier + ":" + user_name;
//    }
//
    public boolean passwordMatches(String password) {
        return password.equals(this.password);
    }

    public void addComment(Course course, String semester, Comment comment){
        this.student_comments.add(comment);
        if (courses.contains(course)){
            CoursePage cp = AllCourses.linked_page.get(course.getCourse_code());
            PostPage pp = cp.getPostPage(course.course_start_year);
            pp.comment_list.add(comment);
        }
    }

    public void editComment(Course course, String semester, Comment comment, String edit) {
        comment.comment = edit;
    }

    public static void main(String[] args) {
        Course csc = new Course("CSC", "blah", "2019");
        CoursePage cp = new CoursePage(csc);
        Student s = new Student("S", "S", "123");
        System.out.print(s.student_comments);
        //AllCourses.linked_page.put("CSC", cp);
        AllCourses.add_to_list("CSC", cp);
        Comment c = new Comment(1, "wtf");
        s.addComment(csc, "2019", c);
        System.out.print(s.student_comments);
    }
}