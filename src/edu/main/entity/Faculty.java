package entity;

public class Faculty extends User {
    public Faculty(String identifier, String name, String password){
        super(identifier, name, password);
    }

    @Override
    public String getUserName() {
        return this.user_name;
    }
}
