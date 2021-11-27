package use_case.EnrollandDropCourse;

import entity.Course;
import use_case.JavaStorage.AllCourses;
import entity.Professor;
import entity.User;
import entity.Student;

public class EnrollCourses {
    public void Teaching_course(String course_name, Professor professor)
    {

        if (AllCourses.coursePageHashMap.containsKey(course_name)){
            professor.getTaughtCourses().add(course_name);
            System.out.println("Dear" + professor.user_name+ "Course:" + course_name + "added successfully");
        } else{
            System.out.println("Dear" + professor.user_name+ "Course:" + course_name + "did not Exist, please check the course code");
        }
    }

    public void enroll_course(String course_name, Student student)
    {

        if (AllCourses.coursePageHashMap.containsKey(course_name)){
            student.getstudentCourses().add(course_name);
            System.out.println("Dear" + student.user_name+ "Course:" + course_name + "added successfully");
        } else{
            System.out.println("Dear" + student.user_name+ "Course:" + course_name + "did not Exist, please check the course code");
        }
    }

}