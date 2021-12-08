package outerlayer.userinterface.studentprofessorinterface;

import interfaceadaptor.boundaries.DatabaseWriter;
import interfaceadaptor.contollers.Controller;
import outerlayer.userinterface.MainUI;
import outerlayer.userinterface.facultyuserinterface.InputGetter;

import java.util.Objects;

public class EnrollAndDeleteCourseUI {
    static final outerlayer.userinterface.facultyuserinterface.InputGetter input_help = new InputGetter();

    /**
     * the UI for enrol and Course page
     */
    public static void enrollAndDropCoursePage(){
        System.out.println("Please enter 3 to enroll course, 4 to drop course, 9 to back to main menu");
        String type = input_help.getInput(System.in).nextLine();
        if (Objects.equals(type, "9")){
            MainUI.registerSigninUi();
        }
        System.out.println("Please enter the course code.");
        String code = input_help.getInput(System.in).nextLine();
        Controller.control(type, new String[] {code});
        DatabaseWriter.writeCommentableUser();
    }
}
