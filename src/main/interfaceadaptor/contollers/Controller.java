package interfaceadaptor.contollers;

import entity.CommentableUser;
import entity.Professor;
import interfaceadaptor.Presenter.CommentableUserPresenter;
import interfaceadaptor.loginlogout.Login;
import outerlayer.userinterface.studentprofessorinterface.StudentProfessorUI;
import usecase.adddeleteeditcomment.CommentAdder;
import usecase.adddeleteeditcomment.CommentDeleter;
import usecase.adddeleteeditcomment.CommentEditer;
import usecase.createupdate.CourseCreator;
import usecase.createupdate.CourseUpdater;
import usecase.enrolldropcourse.CourseDropper;
import usecase.enrolldropcourse.CourseEnroller;


public class Controller {
    public static void control(String s, String[] args) {
        CommentableUserPresenter cup = new CommentableUserPresenter();
        switch (s) {
            case "1" -> CourseCreator.createCourse(args[0], args[1], args[2]);
            case "2" -> CourseUpdater.updateCourseInfo(args[0], args[1], args[2]);
            case "3" -> CourseEnroller.enrollCourse(args[0], (CommentableUser) Login.loggedInUser);
            case "4" -> CourseDropper.dropCourse(args[0], (CommentableUser) Login.loggedInUser);
            case "5" -> CommentAdder.addComment((CommentableUser) Login.loggedInUser, args[0], args[1], Integer.valueOf(args[2]));
            case "6" -> CommentEditer.editComment((CommentableUser) Login.loggedInUser, args[0], args[1], Integer.valueOf(args[2]));
            case "7" -> {
                if (Login.loggedInUser instanceof Professor) {
                    CommentDeleter.deleteComment((Professor) Login.loggedInUser, args[0], Integer.valueOf(args[1]));
                } else {
                    CommentDeleter.deleteComment((CommentableUser) Login.loggedInUser, args[0], Integer.valueOf(args[1]));
                }

            }
            case "8" -> cup.presenterRequiresUserInfo(args[0], (CommentableUser) Login.loggedInUser);
            case "9" -> StudentProfessorUI.StuProPage();
            case "10" -> CommentableUserPresenter.commentableUserCourseListPresenter((CommentableUser) Login.loggedInUser);

        }

    }}

