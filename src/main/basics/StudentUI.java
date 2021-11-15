package basics;


import AddCourse.CoursePage;
import AddCourse.CreateandUpdate;
import AddCourse.GetCourseUI;
import AddCourse.GetInputIn;

import java.util.Objects;
import static basics.commandUI_new.register_signin_ui;

public class StudentUI {
    public StudentUI() {
    }
    static final GetInputIn input_help = new GetInputIn();

    public static String load_course_code() {
        System.out.println("Please enter course code: \n");
        String code = input_help.getinput(System.in).nextLine();
        return code;
    }

    public static String[] load_comment() {
        System.out.println("Please enter content of the comment");
        String content = input_help.getinput(System.in).nextLine();
        System.out.println("Please enter the id of the comment that you want to reply to or want to delete. (Type None if you do not want to reply to anyone)");
        String id = input_help.getinput(System.in).nextLine();
        return new String[]{content, id};
    }

    public static void get_method(){
        System.out.println("""
                Choose which operation you want to make:\s
                 1: enroll course 2: drop course 3: see the course page 4:add comment 5:delete comment \s
                 Please enter 1, 2 or 3, enter quit to return to the main menu""");
        String input_str = input_help.getinput(System.in).nextLine();
        if (input_str.equals("quit")){
            register_signin_ui();
        }
        while (!(input_str.equals("1")||input_str.equals("2")||input_str.equals("3")||input_str.equals("4")||input_str.equals("5")||input_str.equals("quit"))){
            System.out.println("Please enter 1, 2, 3, 4, 5 or type quit to quit");
            input_str = input_help.getinput(System.in).nextLine();
        }
        if (Objects.equals(input_str, "quit")){
            register_signin_ui();
        }
        String course_code = load_course_code();

        if (Objects.equals(input_str, "1")){
            ((Student) Status.user).enroll_course(course_code);
        } else if (Objects.equals(input_str, "2")) {
            ((Student) Status.user).delete_course(course_code);
        } else if (Objects.equals(input_str, "3")){
            System.out.println("Please enter your the course code to see your comments");
            String coursecode = input_help.getinput(System.in).nextLine();
            Status.user.user_comment(coursecode);
        } else if (Objects.equals(input_str, "4")){
            String[] args = load_comment();
            if (args[1] == "None") {
            ((Student) Status.user).add_comment(args[0], course_code);
            } else{
                int i = Integer.parseInt(args[1]);
                ((Student) Status.user).add_comment(args[0], course_code, i);
            }

        } else{
            String[] args = load_comment();
            int i = Integer.parseInt(args[1]);
            ((Student) Status.user).delete_comment(i,course_code);

        }
    }
}
