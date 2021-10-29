package basics;

import java.util.Objects;


public class Signup {

    private final Inputinterface inputiterface;

    public Signup(Inputinterface logininputboundary) {
        this.inputiterface = logininputboundary;
    }

    public String runLogin(String type, String username, String id, String password) {
        LoginUser.ResultOutput result = inputiterface.login(type, username, id, password);
        switch (result) {
            case SUCCESS:
                System.out.println("Success");
                return "Success login";
            case FAILURE:
                System.out.println("Login fails, please try again");
                return "Fail";
            case WRONG:
                System.out.println("id not exists, please try again");
                return "id not exists";
        }
        return "";
    }

    public void register(String type, String username, String id, String password) {
        if (Objects.equals(type, "student")){
            Student new_student = new Student(username, id, password);
            AllStudent.students.put(id, new_student);
            System.out.println("Successfully signup");
        }
    }
}