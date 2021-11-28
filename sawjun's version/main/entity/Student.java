package main.entity;

import java.util.HashMap;

public class Student extends CommentableUser{
    private HashMap<String, String> enrolledcourses;

    public Student(String username, String password){
        super(username, password);
        this.enrolledcourses = new HashMap<>();
        //Key coursename, value semester
    }

    @Override
    public boolean canAddComment(String courseName, String semester) {
        if (this.enrolledcourses.isEmpty()){
            return false;
        }
        if(!this.enrolledcourses.containsKey(courseName)){
            return false;
        }
        return this.enrolledcourses.get(courseName).equals(semester);
    }

    @Override
    public boolean canDeleteComment(String courseName, String semester, Comment comment) {
        if (!canAddComment(courseName, semester)){
            return false;
        }
        if (this.getComments().isEmpty()){
            return false;
        }
        String s = courseName + " " + semester;
        if(!this.getComments().containsKey(s)){
            return false;
        }
        return this.getComments().get(s).contains(comment);

    }

    public HashMap<String, String> getEnrolledcourses() {
        return enrolledcourses;
    }
}