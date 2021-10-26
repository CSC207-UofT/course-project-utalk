package main;

import java.util.ArrayList;

public class Student extends User{
    private ArrayList<Comment> student_comments;
    private ArrayList<CoursePage> student_course;
    private String identifier;
    private String user_name;
    private String password;
    // Do we need to restate the instance attribute for student?
    Student(String student_name, String identifier, String password){
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

}