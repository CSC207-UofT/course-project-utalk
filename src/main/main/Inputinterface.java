package main;

/**
 * The input boundary for the login use case.
 */
public interface Inputinterface {
    LoginUser.ResultOutput login(
            String type, String username, String id, String password
    );
}