package outerlayer.userinterface.presenteruserinterface;

import interfaceadaptor.presenter.CoursePagePresenter;
import outerlayer.userinterface.facultyuserinterface.InputGetter;

/**
 * The CoursePagePresenterUI, scan the course code String and semester information, and then output PostPages or quit.
 */
public class CoursePagePresenterUI {
    static final InputGetter input_help = new InputGetter();
    public static String courseCode = null;

    public static String coursePagePresenterUI() {
        CoursePagePresenter cpp = new CoursePagePresenter();
        System.out.println("Please enter course code: \n");
        courseCode = input_help.getInput(System.in).nextLine();
        cpp.generalPresenter(courseCode);
        CoursePagePresenter.semesterPresenter();
        System.out.println("Please enter the semester information: \n");
        String semester = input_help.getInput(System.in).nextLine();
        CoursePagePresenter.pagePresenter(semester);
        return courseCode;
    }
}

