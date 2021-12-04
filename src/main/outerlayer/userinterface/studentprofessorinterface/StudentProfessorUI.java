package outerlayer.userinterface.studentprofessorinterface;


import entity.CommentableUser;
import interfaceadaptor.boundaries.DatabaseWriter;
import interfaceadaptor.contollers.Controller;
import interfaceadaptor.loginlogout.Login;
import outerlayer.userinterface.facultyuserinterface.InputGetter;
import outerlayer.userinterface.presenteruserinterface.PresenterUI;

public class StudentProfessorUI {
    static final outerlayer.userinterface.facultyuserinterface.InputGetter input_help = new InputGetter();
    public static void StuProPage(){
        if (Login.loggedInUser instanceof CommentableUser){
            if (((CommentableUser) Login.loggedInUser).getCourseList().size() == 0){
                System.out.println("Please enter the course you want to enroll");
                EnrollAndDeleteCourse.enrollAndDropCoursePage();
            } else {
                System.out.println("Which action you want to make? Enter 3 for enroll course, 4 for drop Course, 1 for view pages, add or delete your comment, 9 for back ");
                String type = input_help.getInput(System.in).nextLine();
                while (!type.matches("[1349]")){
                    System.out.println("Which action you want to make? Enter 3 for enroll course, 4 for drop Course, 1 for view pages, add or delete your comment, 9 for back ");
                    type = input_help.getInput(System.in).nextLine();
                }
                if (type.equals("1")){
                    System.out.println("Please enter the course code.");
                    String courseCode = input_help.getInput(System.in).nextLine();
                    CommentUI.CommentPage(courseCode);
                } else if (type.equals("9")){
                    Controller.control("9", new String[]{});
                } else{
                    EnrollAndDeleteCourse.enrollAndDropCoursePage();
                }
            }
        }
        StudentProfessorUI.StuProPage();
        PresenterUI.coursePagePresenterUI();
        CommentUI.CommentPage(PresenterUI.courseCode);

    }

}
