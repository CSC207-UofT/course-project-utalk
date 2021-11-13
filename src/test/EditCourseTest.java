import AddCourse.AllCourses;
import AddCourse.AllcourseToUI;
import AddCourse.Faculty;
import basics.Status;

public class EditCourseTest {
    public static void main(String[] args) {
        Status.user = new Faculty("1", "faculty1", "1");
        AllcourseToUI allcourseToUI = new AllcourseToUI();

        assert allcourseToUI.update_course("CSC207", "software design1", "Fall2021");
        assert allcourseToUI.update_course("CSC207", "software design", "Fall2022");
        assert AllCourses.coursePageHashMap.get("CSC207").post_page_List.size() == 2;
    }
}
