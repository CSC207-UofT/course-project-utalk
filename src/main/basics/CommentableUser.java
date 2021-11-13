package basics;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CommentableUser extends User implements EnrollCourse, DeleteCourse{
    protected HashMap<String, ArrayList<Comment>> comments;

    protected CommentableUser(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
        this.comments = new HashMap<>();
    }

    public void addCourseComments(String courseCode){
        if (!this.containsCourseCode(courseCode)) {
            ArrayList<Comment> a = new ArrayList<>();
            this.comments.put(courseCode, a);
        }
    }

    public ArrayList<Comment> getCourseComments(String courseCode){
        if (this.containsCourseCode(courseCode)){
            return this.comments.get(courseCode);
        }
        return null;
    }

    public boolean containsCourseCode(String courseCode){
        return this.comments.containsKey(courseCode);
    }


    @Override
    abstract public void deleteCourse(String courseCode);

    @Override
    abstract public void enrollCourse(String courseCode);

}
