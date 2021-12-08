package interfaceadaptor.contollers;

import entity.CommentableUser;
import entity.Professor;
import interfaceadaptor.presenter.CommentableUserPresenter;
import interfaceadaptor.loginlogout.Login;
import usecase.adddeleteeditcomment.CommentAdder;
import usecase.adddeleteeditcomment.CommentDeleter;
import usecase.adddeleteeditcomment.CommentEditer;
import usecase.createupdate.CourseCreator;
import usecase.createupdate.CourseUpdater;
import usecase.enrolldropcourse.CourseDropper;
import usecase.enrolldropcourse.CourseEnroller;


public class Controller {
    /**
     * @param s the type of action the user chose
     * @param input The String[] of input needed to carry out actions.
     */
    public static void control(String s, String[] input) {
        CommentableUserPresenter cup = new CommentableUserPresenter();
        switch (s) {
            case "1" -> CourseCreator.createCourse(input[0], input[1], input[2]);
            case "2" -> CourseUpdater.updateCourseInfo(input[0], input[1], input[2]);
            case "3" -> CourseEnroller.enrollCourse(input[0], (CommentableUser) Login.loggedInUser);
            case "4" -> CourseDropper.dropCourse(input[0], (CommentableUser) Login.loggedInUser);
            case "5" -> System.out.println(CommentAdder.addComment((CommentableUser) Login.loggedInUser, input[0], input[1], Integer.valueOf(input[2])));
            case "6" -> System.out.println(CommentEditer.editComment((CommentableUser) Login.loggedInUser, input[0], input[1], Integer.parseInt(input[2])));
            case "7" -> {
                if (Login.loggedInUser instanceof Professor) {
                    System.out.println(CommentDeleter.deleteCommentProf((Professor) Login.loggedInUser, input[0], Integer.parseInt(input[1])));
                } else {
                    System.out.println(CommentDeleter.deleteComment((CommentableUser) Login.loggedInUser, input[0], Integer.parseInt(input[1])));
                }

            }
            case "8" -> cup.presenterRequiresUserInfo(input[0], (CommentableUser) Login.loggedInUser);
            case "10" -> CommentableUserPresenter.commentableUserCourseListPresenter((CommentableUser) Login.loggedInUser);


        }

    }}

