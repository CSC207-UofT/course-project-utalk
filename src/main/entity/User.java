package entity;

public abstract class User {
    private final String username;
    private String password;

    protected User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return this.username;
    }

    public String getPassword() {return this.password;}

    public void setPassword(String password){this.password = password;}

}
