// the class store student objects

import java.util.HashMap;
import java.util.Map;

public class AllStudent {
    static Map<String, Student> students = new HashMap<>();


    /**
     * Return the User associated with username.
     * @param studentname the username of the user to get.
     */
    public Student getstudent(String studentname) {
        return students.get(studentname);
    }

}