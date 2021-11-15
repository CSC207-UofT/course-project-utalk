import AddCourse.AllCourses;
import AddCourse.CreateandUpdate;
import AddCourse.Faculty;
import basics.Status;

public class AddCourseTest {
    public static void main(String[] args) {
        Status.user = new Faculty("1", "1", "1");
        CreateandUpdate createandUpdate = new CreateandUpdate();
        createandUpdate.runaddcourse(new String[]{"CSC207", "1", "1"});
        assert AllCourses.coursePageHashMap.containsKey("CSC207");
    }
}