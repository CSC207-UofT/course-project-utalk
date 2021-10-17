import java.util.Objects;

/**
 * Controls the process for logging in.
 */
// If we handled logging out as well, this would be a good controller
// to do it in. It could have runLogin and runLogout methods.
public class LoginController {

    /**
     * The input boundary for the login use gcase.
     */
    private final LoginInputBoundary loginInputBoundary;

    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     * @param loginInputBoundary the input boundary for the login use case
     */
    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    /**
     * Run the login use case where username is attempting to log into their
     * account with a password attempt.
     * @param username the username
     * @param password the password attempt
     */
    public void runLogin(String type, String username, String id, String password) {
        // Note: hands off the work to the use case class.
        LoginUseCase.LoginResult result = loginInputBoundary.logIn(type, username, id, password);
        switch (result) {
            case SUCCESS:
                // Should we be printing? How might you refactor this program
                // to fit the Clean Architecture?
                System.out.println("Success!");
                break;
            case FAILURE:
                System.out.println("Failed to login!");
                break;
        }
    }

    public void register(String type, String username, String id, String password) {
        if (Objects.equals(type, "student")){
            Student new_student = new Student(username, id, password);
            AllStudent.students.put(id, new_student);
            System.out.println("Registered successfully!");
        }
    }
}
