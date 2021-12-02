package outerlayer.userinterface.presenteruserinterface;

import entity.CommentableUser;
import entity.Professor;
import entity.Student;
import interfaceadaptor.Presenter.CoursePagePresenter;
import interfaceadaptor.Presenter.Printer;
import outerlayer.userinterface.facultyuserinterface.InputGetter;

import java.util.Objects;

/**
 * The PresenterUI, scan the course code String and semester information, and then output PostPages or quit.
 */
public class PresenterUI {
    static final InputGetter input_help = new InputGetter();
    public static String courseCode = null;
    public static void coursePagePresenterUI() {
        System.out.println("Please enter course code: \n");
        courseCode = input_help.getInput(System.in).nextLine();
        CoursePagePresenter cpp = new CoursePagePresenter();
        cpp.coursePresenter(courseCode);
        System.out.println("Please enter the semester information: \n");
        String semester = input_help.getInput(System.in).nextLine();
        cpp.pagePresenter(semester);
    }
    public static void commentPresenterUI(CommentableUser commentableUser) {
        System.out.println("Please enter course code: \n");
        String code = input_help.getInput(System.in).nextLine();
        Printer cp = new Printer();
        cp.commentableUserCommentPresenter(code, commentableUser);
        }
}
    // work need to do: testing and connection between other UI

