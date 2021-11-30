package usecase.enrolldropcourse;

import entity.Professor;
import entity.Student;

public class CourseDropper {


    /**
     * Remove the course from your course list, If it does not exist it will return warning
     *
     * @param course_name the course you want to remove from your course list
     * @param professor the name of the current user
     */
    public static void dropCourse(String course_name, Professor professor)
    {

        if (professor.getTaughtCourses().contains(course_name)){
            professor.getTaughtCourses().remove(course_name);
            System.out.println("Dear" + professor.user_name+ "Course:" + course_name + "removed successfully");
        } else{
            System.out.println("Dear" + professor.user_name+ "Course:" + course_name + "did not Exist in your course " +
                    "list, please check the course code");
        }
    }


    /**
     * Remove the course from your course list, If it does not exist it will return warning
     *
     * @param course_name the course you want to remove from your course list
     * @param student the name of the current user
     */
    public static void dropCourse(String course_name, Student student)
    {

        if (student.getStudentCourses().contains(course_name)){
            student.getStudentCourses().remove(course_name);
            System.out.println("Dear" + student.user_name+ "Course:" + course_name + "removed successfully");
        } else{
            System.out.println("Dear" + student.user_name+ "Course:" + course_name + "did not Exist in your course " +
                    "list ,please check the course code");
        }
    }
}






