package usecase.enrolldropcourse;

import usecase.javastorage.AllCourses;
import entity.Professor;
import entity.Student;

public class EnrollCourses {

    /**
     * Add the course to your course list, If it does not exist it will return warning
     *
     * @param course_name the course you want to add to your course list
     * @param professor the name of the current user
     */
    public void teachingCourse(String course_name, Professor professor)
    {

        if (AllCourses.coursePageHashMap.containsKey(course_name)){
            professor.getTaughtCourses().add(course_name);
            System.out.println("Dear" + professor.user_name+ "Course:" + course_name + "added successfully");
        } else{
            System.out.println("Dear" + professor.user_name+ "Course:" + course_name + "did not Exist, please check the course code");
        }
    }

    /**
     * Add the course to your course list, If it does not exist it will return warning
     *
     * @param course_name the course you want to add to your course list
     * @param student the name of the current user
     */
    public void enrollCourse(String course_name, Student student)
    {

        if (AllCourses.coursePageHashMap.containsKey(course_name)){
            student.getStudentCourses().add(course_name);
            System.out.println("Dear" + student.user_name+ "Course:" + course_name + "added successfully");
        } else{
            System.out.println("Dear" + student.user_name+ "Course:" + course_name + "did not Exist, please check the course code");
        }
    }

}