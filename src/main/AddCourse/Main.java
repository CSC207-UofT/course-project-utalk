package basics;

import AddCourse.CreateandUpdate;
import AddCourse.GetCourseUI;

public class Main {
// how to balance between duplicate code and single module?
    public static void main(String[] args) {
        AllStudent student = new AllStudent();
        LoginUser useCase = new LoginUser(student); //use case
        Signup controller = new Signup(useCase);
        CommandLineUI ui = new CommandLineUI(); //UI
        ui.runLogin(controller);
        // functionality one, create course
        GetCourseUI courseUI = new GetCourseUI();
        CreateandUpdate createandUpdate = new CreateandUpdate();
        createandUpdate.runaddcourse(courseUI.loaddata());
        // functionality two, create course info
        createandUpdate.updatecourseinfo(courseUI.loaddata());
        // functionality three, create new semester
        createandUpdate.updatecourseinfo(courseUI.loaddata());
    }
}
