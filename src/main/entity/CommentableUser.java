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
     * @param courseName The name of course
     * @return true if user can add comment, otherwise return false.
     */
    public boolean canAddComment(String courseName){
        CoursePage cp = AllCourses.coursePageHashMap.get(courseName);
        String s = this.getClassString();
        return switch (s) {
            case "Student" -> cp.isStudent(this.getUserName());
            case "Professor" -> cp.isProfessor(this.getUserName());
            default -> false;
        };
    }

    public abstract String getClassString();

    /**
     * @param course The course that contains comments
     * @return CommentableUser's comments on that course.
     */
    public ArrayList<Comment> getCourseComments(String course) {
        if (comments.containsKey(course)) {
            return comments.get(course);
        }
        return null;
    }

    /**
     * @return The name of specific CommentableUser.
     */
    public String getUserName() {
        return this.user_name;
    }
}
