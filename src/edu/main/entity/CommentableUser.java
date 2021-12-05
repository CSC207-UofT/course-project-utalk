package entity;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class CommentableUser extends User{
    private HashMap<String, ArrayList<Comment>> comments;
    private ArrayList<String> courses;

    public CommentableUser(String identifier, String username, String password) {
        super(identifier, username, password);
        this.comments = new HashMap<>();
        this.courses = new ArrayList<>();
    }

    public HashMap<String, ArrayList<Comment>> getComments(){
        return this.comments;
    }
    public void courseCommentSetter(String courseCode){
        comments.put(courseCode, new ArrayList<>());
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
    public ArrayList<String> getCourseList(){
        return this.courses;
    }
    public void addCommentToList(String courseCode, Comment comment){
        if (!comments.containsKey(courseCode)){
            comments.put(courseCode, new ArrayList<>());
        }
        comments.get(courseCode).add(comment);
    }
}
