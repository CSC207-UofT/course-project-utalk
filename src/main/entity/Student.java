package entity;

import java.util.HashMap;

public class Student extends CommentableUser{
    private HashMap<String, String> enrolledcourses;

    public Student(String username, String password){
        super(username, password);
        this.enrolledcourses = new HashMap<>();
        //Key coursename, value semester
    }
    public HashMap<String, String> getEnrolledCourses() {
        return enrolledcourses;
    }

    @Override
    public boolean canAddComment(String courseName, String semester) {
        boolean b1 = this.enrolledcourses.containsKey(courseName);
        boolean b2 = this.enrolledcourses.get(courseName).equals(semester);
        return b1 && b2;
    }

    @Override
    public boolean canDeleteComment(String courseName, String semester, Comment comment) {
        if (canAddComment(courseName, semester)){
            return true;
        }
        String s = courseName + " " + semester;
        return this.getComments().get(s).contains(comment);

    }
}
