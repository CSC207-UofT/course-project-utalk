import AddCourse.AllCourses;
import AddCourse.Faculty;
import basics.Status;

public class UpdateCourseInfoTest {
    public static void main(String[] args) {
        Status.user = new Faculty("1", "faculty1", "1");

        assert AllCourses.coursePageHashMap.get("CSC207").post_page_List.size() == 2;

    }
}
