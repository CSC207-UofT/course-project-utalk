package basics;

public class User {
    final String identifier;
    public String user_name;
    private String password;
    protected User(String identifier, String user_name, String password){
        this.identifier = identifier;
        this.user_name = user_name;
        this.password = password;
    }
    public String user_name(){
        return this.user_name;
    }
    public void user_comment(String course) {
    }

}
