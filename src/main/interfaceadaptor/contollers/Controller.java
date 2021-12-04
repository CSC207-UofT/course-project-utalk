package interfaceadaptor.contollers;

import entity.CommentableUser;
import entity.Professor;
import interfaceadaptor.Presenter.Printer;
import interfaceadaptor.loginlogout.Login;
import outerlayer.userinterface.MainUI;
import outerlayer.userinterface.studentprofessorinterface.StudentProfessorUI;
import usecase.adddeleteeditcomment.CommentAdder;
import usecase.adddeleteeditcomment.CommentDeleter;
import usecase.adddeleteeditcomment.CommentEditer;
import usecase.createupdate.CourseCreator;
import usecase.createupdate.CourseUpdater;
import usecase.enrolldropcourse.CourseDropper;
import usecase.enrolldropcourse.CourseEnroller;
import interfaceadaptor.Presenter.Printer;


public class Controller {
    public static void control(String s, String[] args) {
        switch (s) {
            case "1" -> CourseCreator.createCourse(args[0], args[1], args[2]);
            case "2" -> CourseUpdater.updateCourseInfo(args[0], args[1], args[2]);
            case "3" -> {
                CourseEnroller.enrollCourse(args[0], (CommentableUser) Login.loggedInUser);
            }
            case "4" -> CourseDropper.dropCourse(args[0], (CommentableUser) Login.loggedInUser);
            case "5" -> CommentAdder.addComment((CommentableUser) Login.loggedInUser, args[0], args[1], Integer.valueOf(args[2]));
            case "6" -> CommentEditer.editComment((CommentableUser) Login.loggedInUser, args[0], args[1], Integer.valueOf(args[2]));
            case "7" -> {if(Login.loggedInUser instanceof Professor) {
                CommentDeleter.deleteComment((Professor) Login.loggedInUser, args[0], Integer.valueOf(args[1]));
            }
            else{
                CommentDeleter.deleteComment((CommentableUser) Login.loggedInUser, args[0], Integer.valueOf(args[1]));
            }

            }
            case "8" -> Printer.commentableUserCommentPresenter(args[0], (CommentableUser)Login.loggedInUser);
            // TODO:  Need dependency inversion;
            case "9" -> StudentProfessorUI.StuProPage();
        }

    }}

