import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    public static void main(String[] args) {
        AllStudent student = new AllStudent();
        LoginUseCase useCase = new LoginUseCase(student); //use case
        LoginController controller = new LoginController(useCase); //controller
        controller.register("student", "Steven", "wangz", "zhijun");
        String outpt = controller.runLogin("student", "Steven", "wangz", "zhijun");
        assert Objects.equals(outpt, "Success");
    }

}