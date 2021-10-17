/**
 * The input boundary for the login use case.
 */
public interface LoginInputBoundary {
    LoginUseCase.LoginResult logIn(String type, String username, String id, String password);
}