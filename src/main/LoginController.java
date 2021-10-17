import java.util.Objects;


public class LoginController {

    private final LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    public String runLogin(String type, String username, String id, String password) {
        LoginUseCase.LoginResult result = loginInputBoundary.logIn(type, username, id, password);
        switch (result) {
            case SUCCESS:
                System.out.println("Success");
                return new String("Success!");
            case FAILURE:
                System.out.println("Login fails, please try again");
                return new String("Fail");
        }
        return new String("");
    }

    public void register(String type, String username, String id, String password) {
        if (Objects.equals(type, "student")){
            Student new_student = new Student(username, id, password);
            AllStudent.students.put(id, new_student);
            System.out.println("Registered successfully!");
        }
    }
}