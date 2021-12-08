package usecase.enrolldropcourse;

import entity.CommentableUser;
import entity.Professor;
import entity.Student;
import usecase.javastorage.AllCourses;

public class CourseDropper {


    /**
     * Remove the course from your course list, If it does not exist it will return warning
     *
     * @param course_name the course you want to remove from your course list
     * @param user the name of the current user
     */
    public static void dropCourse(String course_name, CommentableUser user)
    {

        if (user.getCourseList().contains(course_name)){
            if (user.getClassString().equals("Student")) {
                AllCourses.coursePageHashMap.get(course_name).student_list.remove((Student)user);
            } else{
                AllCourses.coursePageHashMap.get(course_name).professor_list.remove((Professor) user);}
            user.getCourseList().remove(course_name);
            System.out.println("Dear " + user.user_name+ ", Course:" + course_name + " has been removed successfully");
        } else{
            System.out.println("Dear " + user.user_name+ ", Course:" + course_name + " did not Exist in your course " +
                    "list, please check the course code and try again.");
        }
    }



}






