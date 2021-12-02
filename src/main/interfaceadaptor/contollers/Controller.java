package interfaceadaptor.contollers;

import entity.CommentableUser;
import entity.Professor;
import interfaceadaptor.loginlogout.Login;
import usecase.createupdate.CourseCreator;
import usecase.createupdate.CourseUpdater;
import usecase.enrolldropcourse.CourseDropper;
import usecase.enrolldropcourse.CourseEnroller;


public class Controller {
    public static void control(String s, String[] args) {
        switch (s) {
            case "1" -> CourseCreator.createCourse(args[0], args[1], args[2]);
            case "2" -> CourseUpdater.updateCourseInfo(args[0], args[1], args[2]);
            case "3" -> {
                CourseEnroller.enrollCourse(args[0], (CommentableUser) Login.loggedInUser);
            }
            case "4" -> CourseDropper.dropCourse(args[0], (CommentableUser) Login.loggedInUser);
        }

    }}

