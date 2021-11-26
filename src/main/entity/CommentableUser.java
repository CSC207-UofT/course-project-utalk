package entity;

import use_case.JavaStorage.AllCourses;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CommentableUser extends User{
    private HashMap<String, ArrayList<Comment>> comments;

    public CommentableUser(String identifier, String username, String password) {
        super(identifier, username, password);
        this.comments = new HashMap<>();
    }

    public HashMap<String, ArrayList<Comment>> getComments(){
        return this.comments;
    }

    /**
     * @param courseName
     * @return true if user can add comment, otherwise return false.
     */
    public boolean canAddComment(String courseName){
        CoursePage cp = AllCourses.coursePageHashMap.get(courseName);
        String s = this.getClassString();
        switch(s) {
            case "Student":
                return cp.isStudent(this.getUserName());
            case "Professor":
                return cp.isProfessor(this.getUserName());
        }
        return false;
    }

    public abstract String getClassString();

    public abstract ArrayList<Comment> getCourseComments(String course);

    public abstract String getUserName();
}
