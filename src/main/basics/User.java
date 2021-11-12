package basics;

public class User {
    protected String identifier;
    protected String user_name;
    protected String password;
    protected User(String identifier, String user_name, String password){
        this.identifier = identifier;
        this.user_name = user_name;
        this.password = password;
    }

}
