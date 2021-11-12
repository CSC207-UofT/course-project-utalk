
import AddCourse.AllcourseToUI;
import AddCourse.Faculty;
import basics.Status;
import basics.Student;

public class AddCourseTest {
    public AddCourseTest() {
    }

    public static void main(String[] args) {
        Status.user = new Faculty("1", "faculty1", "1");
        AllcourseToUI allcourseToUI = new AllcourseToUI();

        assert allcourseToUI.add_course("CSC207", "software design", "Fall2021");

        Status.user = new Student("2", "student1", "2");

        assert !allcourseToUI.add_course("CSC207", "software design", "Fall2021");

    }
}