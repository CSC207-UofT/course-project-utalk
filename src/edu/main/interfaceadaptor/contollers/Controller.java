package interfaceadaptor.contollers;

import entity.CommentableUser;
import entity.Professor;
import interfaceadaptor.presenter.CommentableUserPresenter;
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


public class Controller {
    public static void control(String s, String[] args) {
        CommentableUserPresenter cup = new CommentableUserPresenter();
        switch (s) {
            case "1" -> CourseCreator.createCourse(args[0], args[1], args[2]);
            case "2" -> CourseUpdater.updateCourseInfo(args[0], args[1], args[2]);
            case "3" -> CourseEnroller.enrollCourse(args[0], (CommentableUser) Login.loggedInUser);
            case "4" -> CourseDropper.dropCourse(args[0], (CommentableUser) Login.loggedInUser);
            case "5" -> System.out.println(CommentAdder.addComment((CommentableUser) Login.loggedInUser, args[0], args[1], Integer.valueOf(args[2])));
            case "6" -> System.out.println(CommentEditer.editComment((CommentableUser) Login.loggedInUser, args[0], args[1], Integer.parseInt(args[2])));
            case "7" -> {
                if (Login.loggedInUser instanceof Professor) {
                    System.out.println(CommentDeleter.deleteCommentProf((Professor) Login.loggedInUser, args[0], Integer.parseInt(args[1])));
                } else {
                    System.out.println(CommentDeleter.deleteComment((CommentableUser) Login.loggedInUser, args[0], Integer.parseInt(args[1])));
                }

            }
            case "8" -> cup.presenterRequiresUserInfo(args[0], (CommentableUser) Login.loggedInUser);
            case "9" -> MainUI.registerSigninUi();
            case "10" -> CommentableUserPresenter.commentableUserCourseListPresenter((CommentableUser) Login.loggedInUser);


        }

    }}

