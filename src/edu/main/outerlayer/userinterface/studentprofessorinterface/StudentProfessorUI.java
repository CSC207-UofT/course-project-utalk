package outerlayer.userinterface.studentprofessorinterface;


import entity.CommentableUser;
import interfaceadaptor.boundaries.DatabaseWriter;
import interfaceadaptor.loginlogout.Login;
import outerlayer.userinterface.MainUI;
import outerlayer.userinterface.facultyuserinterface.InputGetter;
import outerlayer.userinterface.presenteruserinterface.CoursePagePresenterUI;

public class StudentProfessorUI {
    static final InputGetter input_help = new InputGetter();

    /**
     * The UI for user with identity student and professor, they can enrol course drop course add comment to the
     * course they enrolled and delete comment
     */
    public static void StuProPage(){
        if (Login.loggedInUser instanceof CommentableUser){
            if (((CommentableUser) Login.loggedInUser).getCourseList().size() == 0){
                System.out.println("Please enter the course you want to enroll");
                EnrollAndDeleteCourseUI.enrollAndDropCoursePage();
            } else {
                System.out.println("""
                        Which action you want to make?\s
                         Enter 3 for enroll course, 4 for drop Course,\s
                         1 for view pages, add or delete your comment, 9 for back\s""");
                String type = input_help.getInput(System.in).nextLine();
                int count = 0;
                while (!type.matches("[1349]") && count < 100) {
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
                    MainUI.registerSigninUi();
                } else {
                    EnrollAndDeleteCourseUI.enrollAndDropCoursePage();
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
