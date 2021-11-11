package basics;

public class User {
    final String identifier;
    protected String user_name;
    private final String password;
    protected User(String identifier, String user_name, String password){
        this.identifier = identifier;
        this.user_name = user_name;
        this.password = password;
    }

}
