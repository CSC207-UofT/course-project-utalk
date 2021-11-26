package use_case.EnrollandDropCourse;


import entity.Comment;
import entity.CoursePage;
import entity.PostPage;
import entity.User;
import use_case.JavaStorage.AllCourses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

class EnrollCourse extends User {

    private ArrayList<String> taught_courses;
    private HashMap<String, ArrayList<Comment>> comments = new HashMap<>();


    EnrollCourse(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
        HashMap<String, ArrayList<Comment>> comments= new HashMap<>();
        ArrayList<String> taught_courses = new ArrayList<>();
    }

    public String edit_comment(String new_content, int comment_id, String course_code) {
        if (taught_courses.contains(course_code)){
            return "Oh you are not teaching this course";}
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

    public String add_comment(String content, String Course_code) {
        if (!taught_courses.contains(Course_code)){
            return "Oh you are not in this course";
        }
        else{
            LocalDate time = LocalDate.now();
            Comment comment = new Comment();
            PostPage postpage = AllCourses.coursePageHashMap.get(Course_code).post_page_List.get(-1);
            postpage.comments.put(comment.id, comment);
            postpage.posts.add(comment);
            comments.get(Course_code).add(comment);
            return "succeed!";}


    }

    public String add_comment(String content,  String Course_code, int reply_to_id) {
        if (!taught_courses.contains(Course_code)){
            return "Sorry you are teaching in this course";
        }
        if (reply_to_id > AllCourses.coursePageHashMap.get(Course_code).post_page_List.get(-1).current_id){
            return "Sorry this comment does not exist.";
        }
        else{
            LocalDate time = LocalDate.now();
            Comment comment = new Comment();
            CoursePage coursepage = AllCourses.coursePageHashMap.get(Course_code);
            coursepage.post_page_List.get(-1).comments.get(reply_to_id).replies.add(comment);
            comments.get(Course_code).add(comment);
            return "succeed";}
    }

    public String delete_comment(int comment_id, String course_code) {
        if (!taught_courses.contains(course_code)){
            return "Sorry you are teaching in this course";
        }
        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);

        PostPage postpage = coursepage.post_page_List.get(-1);
        if (comment_id > postpage.current_id) {
            return "wrong id";
        } else {
            postpage.comments.get(comment_id).status = false;
            return "delete successfully";
        }


    }

    public void enroll_course(String course_code) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
        taught_courses.add(course_code);
        coursepage.professor_list.add(this);
        ArrayList<Comment> comment = new ArrayList<>();
        comments.put(course_code, comment);
    }

    public void delete_course(String course_code) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
        taught_courses.remove(coursepage);
        coursepage.professor_list.remove(this);

    }

    public void user_comment(String course) {
        for(Comment comment: this.comments.get(course)) {
            comment.Print_Comment(0);
        }
    }
}