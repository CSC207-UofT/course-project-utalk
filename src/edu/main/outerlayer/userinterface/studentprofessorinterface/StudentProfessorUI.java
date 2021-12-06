package outerlayer.userinterface.studentprofessorinterface;


import entity.CommentableUser;
import interfaceadaptor.boundaries.DatabaseWriter;
import interfaceadaptor.contollers.Controller;
import interfaceadaptor.loginlogout.Login;
import outerlayer.userinterface.MainUI;
import outerlayer.userinterface.facultyuserinterface.InputGetter;
import outerlayer.userinterface.presenteruserinterface.CoursePagePresenterUI;

public class StudentProfessorUI {
    static final outerlayer.userinterface.facultyuserinterface.InputGetter input_help = new InputGetter();
    public static void StuProPage(){
        if (Login.loggedInUser instanceof CommentableUser){
            if (((CommentableUser) Login.loggedInUser).getCourseList().size() == 0){
                System.out.println("Please enter the course you want to enroll");
                EnrollAndDeleteCourse.enrollAndDropCoursePage();
            } else {
                System.out.println("""
                        Which action you want to make?\s
                         Enter 3 for enroll course, 4 for drop Course,\s
                         1 for view pages, add or delete your comment, 9 for back\s""");
                String type = input_help.getInput(System.in).nextLine();
                int count = 0;
                while (!type.matches("[1349]") && count < 10) {
                    System.out.println("""
                            Which action you want to make?\s
                             Enter 3 for enroll course, 4 for drop Course,\s
                             1 for view pages, add or delete your comment, 9 for back\s""");
                    type = input_help.getInput(System.in).nextLine();
                    count = count + 1;
                }
                if (type.equals("1")) {

                    CommentUI.CommentPage(CoursePagePresenterUI.coursePagePresenterUI());
                } else if (type.equals("9")) {
                    Controller.control("9", new String[]{});
                } else {
                    EnrollAndDeleteCourse.enrollAndDropCoursePage();
                    DatabaseWriter.writeCommentableUser();
                }
            }
            StudentProfessorUI.StuProPage();
            CoursePagePresenterUI.coursePagePresenterUI();
            CommentUI.CommentPage(CoursePagePresenterUI.courseCode);

        }
        else{
            System.out.println("Please register first");
            MainUI.registerSigninUi();
        }

    }

}
