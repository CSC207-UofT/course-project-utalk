import java.util.Map;

public class LoginUseCase implements LoginInputBoundary {

    /**
     * A list of students organized by username.
     */
    private static Map<String, Student> students;

    /**
     * / The "output" of this use case.
     */
    // Note: This could also be a fully-fledged class if we need to return
    // information to the controller.
    public enum LoginResult {
        SUCCESS, FAILURE // Should we do NO_SUCH_USER as well as SUCCESS and FAILURE?
    }

    public LoginUseCase(AllStudent students) {
        this.students = AllStudent.students;
    }

    /**
     * Run the login use case.
     *
     * @param username the username
     * @param password the password attempt
     * @return whether the attempt matches the password associated with username
     */
    @Override
    public LoginResult logIn(String type, String username, String id, String password) {
        if (type.equals("student")) {
            Student std = students.get(username);
            if (std.passwordMatches(password)) {
                return LoginResult.SUCCESS;
            }
            return LoginResult.FAILURE;

        }
        return null;

    }
}