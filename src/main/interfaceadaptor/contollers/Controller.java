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
            case "1" -> {
                CourseCreator.createCourse(args[0], args[1], args[2]);
            }
            case "2" -> {
                CourseUpdater.updateCourseInfo(args[0], args[1], args[2]);
            }
            case "3" -> {
                if (Login.loggedinUser() instanceof Professor) {
                    CourseEnroller.teachingCourse(args[0], (Professor) Login.loggedinUser());
                } else {
                    CourseEnroller.enrollCourse(args[0], (Student) Login.loggedinUser());
                }
            }
            case "4" -> {
                if (Login.loggedinUser() instanceof Professor) {
                    CourseDropper.dropCourse(args[0],
                            (Professor) Objects.requireNonNull(Login.loggedinUser()));
                } else CourseDropper.dropCourse(args[0], (Student) Objects.requireNonNull(Login.loggedinUser()));
            }
        }
    }

    }

