package use_case.EnrollandDropCourse;

import entity.Course;
import use_case.JavaStorage.AllCourses;
import entity.Professor;
import entity.User;
import entity.Student;

public class Dropcourses {


    public void drop_course(String course_name, Professor professor)
    {

        if (professor.getTaughtCourses().contains(course_name)){
            professor.getTaughtCourses().remove(course_name);
            System.out.println("Dear" + professor.user_name+ "Course:" + course_name + "removed successfully");
        } else{
            System.out.println("Dear" + professor.user_name+ "Course:" + course_name + "did not Exist in your course " +
                    "list" +
                    ", please check the course code");
        }
    }


    public void drop_course(String course_name, Student student)
    {

        if (student.getstudentCourses().contains(course_name)){
            student.getstudentCourses().remove(course_name);
            System.out.println("Dear" + student.user_name+ "Course:" + course_name + "removed successfully");
        } else{
            System.out.println("Dear" + student.user_name+ "Course:" + course_name + "did not Exist in your course " +
                    "list" +
                    ", please check the course code");
        }
    }
}






