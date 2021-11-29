package outerlayer.userinterface.presenteruserinterface;

import entity.CommentableUser;
import entity.Professor;
import entity.Student;

import interfaceadaptor.Presenter.Printer;

import outerlayer.userinterface.facultyuserinterface.InputGetter;
import interfaceadaptor.Presenter.CoursePagePresenter;

import java.util.Objects;

/**
 * The PresenterUI, scan the course code String and semester information, and then output PostPages or quit.
 */
public class PresenterUI {
    static final InputGetter input_help = new InputGetter();
    public void coursePagePresenterUI() {
        System.out.println("Please enter course code: \n");
        String code = input_help.getInput(System.in).nextLine();
        CoursePagePresenter.semesterPresenter(code);
        System.out.println("Please enter the semester information: \n");
        String semester = input_help.getInput(System.in).nextLine();
        CoursePagePresenter cpp = new CoursePagePresenter();
        cpp.coursePresenter(code, semester);
    }
    public void commentPresenterUI(CommentableUser commentableUser) {
        System.out.println("Please enter course code: \n");
        String code = input_help.getInput(System.in).nextLine();
        Printer cp = new Printer();
        if (Objects.equals(commentableUser.getClassString(), "professor")){
            cp.professorCommentPresenter(code, (Professor) commentableUser);
        } else {
            cp.studentCommentPresenter(code, (Student) commentableUser);
        }
    }
    // work need to do: testing and connection between other UI
}
