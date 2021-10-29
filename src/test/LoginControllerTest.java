import basics.AllStudent;
import basics.LoginUser;
import basics.Signup;

import java.util.Objects;

class LoginControllerTest {
    public static void main(String[] args) {
        AllStudent student = new AllStudent();
        LoginUser useCase = new LoginUser(student); //use case
        Signup controller = new Signup(useCase); //controller
        controller.register("student", "Steven", "wangz", "zhijun");
        String outpt = controller.runLogin("student", "Steven", "wangz", "zhijun");
        assert Objects.equals(outpt, "Successfully login");
    }

}