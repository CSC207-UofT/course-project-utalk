import AddCourse.AllCourses;
import AddCourse.CreateandUpdate;
import AddCourse.Faculty;
import AddCourse.GetCourseUI;
import basics.Status;

public class EditCourseTest {
    public static void main(String[] args) {
        Status.user = new Faculty("1", "faculty1", "1");

        CreateandUpdate createandUpdate = new CreateandUpdate();

        createandUpdate.runaddcourse(new String[]{"CSC207", "1", "1"});

        createandUpdate.updatecourseinfo(new String[]{"CSC207", "1", "2"});

        assert AllCourses.coursePageHashMap.get("CSC207").post_page_List.size() == 2;
    }
}
