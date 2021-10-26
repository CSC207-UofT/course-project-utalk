// the class store student objects
package main;
import java.util.HashMap;
import java.util.Map;

public class AllStudent {
    static Map<String, Student> students = new HashMap<>();

    public Student getstudent(String studentname) {
        return students.get(studentname);
    }

}