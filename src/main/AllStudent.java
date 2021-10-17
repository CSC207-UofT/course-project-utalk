// the class store student objects

import java.util.HashMap;
import java.util.Map;

public class AllStudent {
    static Map<String, Student> students = new HashMap<>();

    public Student getstudent(String studentname) {
        return students.get(studentname);
    }

}