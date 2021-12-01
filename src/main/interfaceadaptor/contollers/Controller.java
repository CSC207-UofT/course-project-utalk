package interfaceadaptor.contollers;

import entity.Professor;
import entity.Student;
import interfaceadaptor.loginlogout.Login;
import usecase.createupdate.CourseCreator;
import usecase.createupdate.CourseUpdater;
import usecase.enrolldropcourse.CourseDropper;
import usecase.enrolldropcourse.CourseEnroller;

import java.util.Objects;

public class Controller {
    public static void control(String s, String[] args) {
        switch (s) {
            case "1" -> CourseCreator.createCourse(args[0], args[1], args[2]);
            case "2" -> CourseUpdater.updateCourseInfo(args[0], args[1], args[2]);
            case "3" -> {
                if (Login.loggedInUser instanceof Professor) {
                    CourseEnroller.teachingCourse(args[0], (Professor) Login.loggedInUser);
                } else {
                    CourseEnroller.enrollCourse(args[0], (Student) Login.loggedInUser);
                }
            }
            case "4" -> {
                if (Login.loggedInUser instanceof Professor) {
                    CourseDropper.dropCourse(args[0],
                            (Professor) Objects.requireNonNull(Login.loggedInUser));
                } else CourseDropper.dropCourse(args[0], (Student) Objects.requireNonNull(Login.loggedInUser));
            }
            default -> throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    }

