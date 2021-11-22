package entity;

public class User {
    final String identifier;
    public final String user_name;
    protected final String password;

    protected User(String identifier, String user_name, String password){
        this.identifier = identifier;
        this.user_name = user_name;
        this.password = password;
    }
    public String getUserName(){
        return this.user_name;
    }

}
