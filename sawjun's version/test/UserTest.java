package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import main.entity.User;
import main.entity.Student;

public class UserTest {
    User user = new Student("username", "password");

    @Test
    @DisplayName("Tests User.getUsername() and User.getPassword()")
    void testGetters(){
        Assertions.assertEquals("username", user.getUsername());
        Assertions.assertEquals("password", user.getPassword());
    }

    @Test
    @DisplayName("Tests User.setPassword()")
    void testSetter(){
        user.setPassword("pizza");
        Assertions.assertEquals("pizza", user.getPassword());
    }

}
