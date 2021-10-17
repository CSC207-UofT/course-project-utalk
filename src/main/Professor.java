import java.util.ArrayList;

public class Professor extends User{
    private ArrayList<Course> taught_courses;
    Professor(String identifier, String user_name, String password){
        super(identifier, user_name, password);
        this.taught_courses = new ArrayList<>();
    }

}