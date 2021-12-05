package usecase.enrolldropcourse;

import entity.CommentableUser;
import entity.Professor;
import entity.Student;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class CourseEnroller {



    /**
     * Add the course to your course list, If it does not exist it will return warning
     *
     * @param course_name the course you want to add to your course list
     * @param user the name of the current user
     */
    public static void enrollCourse(String course_name, CommentableUser user)
    {

        if (AllCourses.coursePageHashMap.containsKey(course_name)){
            if(!user.getCourseList().contains(course_name)) {
                user.getCourseList().add(course_name);
                if (user.getClassString().equals("Student")) {
                    AllCourses.coursePageHashMap.get(course_name).student_list.add((Student) user);
                    user.courseCommentSetter(course_name);
                    AllCommentableUser.getAllCommentableUsers().put(user.getUserName(), user);
                    System.out.println("Dear " + user.user_name + "Course: " + course_name + " added successfully");
                } else {
                    AllCourses.coursePageHashMap.get(course_name).professor_list.add((Professor) user);
                    AllCommentableUser.getAllCommentableUsers().put(user.getUserName(), user);
                    user.courseCommentSetter(course_name);
                }
            } else {
                System.out.println("Dear " + user.user_name+ "You have already enrolled Course: " + course_name );
            }
        } else{
            System.out.println("Dear " + user.user_name+ "Course: " + course_name + " did not Exist, please check the course code");
        }
    }

}
