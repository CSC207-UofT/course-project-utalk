package entity;

public class Student extends CommentableUser{


    public Student(String identifier, String user_name, String password) {
        super(identifier, user_name, password);
    }

    @Override
    public String getClassString() {
        return "Student";
    }



}
    
