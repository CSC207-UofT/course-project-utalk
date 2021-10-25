package basics;

import java.util.Map;

public class LoginUser implements Inputinterface {

    private static Map<String, Student> group;

    public enum ResultOutput {
        SUCCESS, FAILURE, WRONG
    }

    public LoginUser(AllStudent students) {
        group = AllStudent.students;
    }

    @Override
    public ResultOutput login(String type, String username, String id, String password) {
        if (type.equals("student")) {
            Student std = group.get(id);
            try {
                if (std.passwordMatches(password)) {
                    return ResultOutput.SUCCESS;
                }
                return ResultOutput.FAILURE;
            } catch (Exception NullPointerException) {
                return ResultOutput.WRONG;

            }

        }
        return null;

    }
}