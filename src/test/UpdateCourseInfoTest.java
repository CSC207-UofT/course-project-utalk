import AddCourse.AllCourses;
import AddCourse.AllcourseToUI;
import AddCourse.Faculty;
import basics.Status;
import AddCourse.AllCourses;

public class UpdateCourseInfoTest {
    public static void main(String[] args) {
        Status.user = new Faculty("1", "faculty1", "1");
        AllcourseToUI allcourseToUI = new AllcourseToUI();

        assert allcourseToUI.add_course("CSC207", "software design", "Fall2021");

        assert allcourseToUI.update_course("CSC207", "software design", "Winter2022");

        assert AllCourses.linked_page.get("CSC207").post_page_List.size() == 2;

    }
}
