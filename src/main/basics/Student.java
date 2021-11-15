package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;
import AddCourse.PostPage;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User implements Add_Comment,Delete_Comment,Edit_Comment {
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

    @Override
    public String edit_comment(String new_content, int comment_id, String course_code) {
        if (!student_course.contains(course_code)){
            return "Oh you are not in this course";}
        if (comment_id > AllCourses.coursePageHashMap.get(course_code).post_page_List.get(-1).current_id){
            return "Oh no such comment";
        }
        else{
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            Comment comment = coursepage.post_page_List.get(-1).comments.get(comment_id);
            if (comment.user_name.equals(user_name) & comment.status) {
                comment.content = new_content;
                return "edit successfully";
            } else {
                return "you can not edit this comment";
            }}

    }

    @Override
    public String delete_comment(int comment_id, String course_code) {
        if (!student_course.contains(course_code)){
            return "Oh you are not in this course";}
        if (comment_id > AllCourses.coursePageHashMap.get(course_code).post_page_List.get(-1).current_id){
            return "Oh no such comment";
        }
        else{
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            Comment comment = coursepage.post_page_List.get(-1).comments.get(comment_id);
            if (comment.user_name.equals(user_name)) {
                comment.status = false;
                return "delete successfully";
            } else {
                return "you can not delete this comment";
            }}
    }


    @Override
    public String add_comment(String content, String Course_code) {
        if (!student_course.contains(Course_code)){
            return "Oh you are not in this course";
        }
        else{
            Comment comment = new Comment(user_name, content, Course_code);
            PostPage postpage = AllCourses.coursePageHashMap.get(Course_code).post_page_List.get(-1);
            postpage.comments.put(comment.id, comment);
            postpage.posts.add(comment);
            student_comments.get(Course_code).add(comment);
            return "succeed!";}


    }

    public String add_comment(String content, String Course_code, int reply_to_id) {
        if (!student_course.contains(Course_code)){
            return "Oh you are not in this course";
        }
        if (reply_to_id > AllCourses.coursePageHashMap.get(Course_code).post_page_List.get(-1).current_id){
            return "Oh this comment does not exist.";
        }
        else{
            Comment comment = new Comment(user_name, content, Course_code);
            CoursePage coursepage = AllCourses.coursePageHashMap.get(Course_code);
            coursepage.post_page_List.get(-1).comments.get(reply_to_id).replies.add(comment);
            student_comments.get(Course_code).add(comment);
            return "succeed";}
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


    //    @Override
//    public String toString(){
//        return identifier + ":" + user_name;
//    }
//
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