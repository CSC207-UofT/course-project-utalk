package entity;

public class Professor extends CommentableUser {

    public Professor(String identifier, String userName, String password) {
        super(identifier, userName, password);
    }

    /**
     * @return String "Professor" as an indicator of this class.
     */
    @Override
    public String getClassString() {
        return "Professor";
    }


}