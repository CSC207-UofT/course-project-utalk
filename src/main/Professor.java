import java.util.ArrayList;

public class Professor extends User implements Registeration{
    private ArrayList<Course> taught_courses;
    Professor(int identifier, String user_name, String password){
        super(identifier, user_name, password);
        this.taught_courses = new ArrayList<>();
    }

    @Override
    public void register(int identifier, String user_name, String password) {
        Professor new_professor = new Professor(identifier, user_name, password);
        AllProfessor.prof_dict.put(user_name, new_professor);
    }
}
