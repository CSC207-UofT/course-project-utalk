package outerlayer.userinterface.studentprofessorinterface;


import outerlayer.userinterface.presenteruserinterface.PresenterUI;

public class StudentProfessorUI {
    public static void StuProPage(){
        PresenterUI.coursePagePresenterUI();
        CommentUI.CommentPage(PresenterUI.courseCode);

    }

}
