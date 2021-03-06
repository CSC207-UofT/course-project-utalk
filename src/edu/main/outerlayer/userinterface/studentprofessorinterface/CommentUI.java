package outerlayer.userinterface.studentprofessorinterface;

import interfaceadaptor.contollers.Controller;
import outerlayer.userinterface.MainUI;
import outerlayer.userinterface.facultyuserinterface.InputGetter;

import java.util.Objects;

public class CommentUI {
    static final InputGetter input_help = new InputGetter();

    /**Load the new comment
     * @return the string with the comment content and user id
     */
    public static String[] loadForAdd() {

        System.out.println("Please enter content:");
        String content = input_help.getInput(System.in).nextLine();
        System.out.println("Please enter the id of comment you want to reply, if you are not replying, type 0: ");
        String id = input_help.getInput(System.in).nextLine();


        return new String[]{content, id};
    }

    /**Edit the comment
     * @return the string with the comment content and user id
     */
    public static String[] loadForEdit() {

        System.out.println("Please enter content: ");
        String content = input_help.getInput(System.in).nextLine();
        System.out.println("Please enter your comment id: ");
        String id = input_help.getInput(System.in).nextLine();


        return new String[]{content, id};
    }

    /**Delet the comment
     * @return the string with the comment id
     */
    public static String[] loadForDelete() {

        System.out.println("Please enter your comment id: ");
        String id = input_help.getInput(System.in).nextLine();


        return new String[]{id};
    }

    public static String[] loadHelper(String[] input, String CourseCode) {
        int a = input.length;
        String[] lst = new String[a + 1];
        lst[0] = CourseCode;
        System.arraycopy(input, 0, lst, 1, a);
        return lst;
    }

    /**The UI for comment page
     * @param CourseCode the course code of that page
     */
    public static void CommentPage(String CourseCode) {
        int count = 0;
        while (count < 100) {
            System.out.println("""
                     Choose which operation you want to make:
                     5: add comment 6: edit comment 7: delete comment 8. view own comment Please enter 5, 6, 7 or 8,
                    enter quit to return to the main menu""");
            String input_str = input_help.getInput(System.in).nextLine();

            while (!input_str.matches("[5678]") && !input_str.equals("quit")) {
                System.out.println("Please enter 5,6,7 or 8, or type quit to quit");
                input_str = input_help.getInput(System.in).nextLine();
            }

            if (Objects.equals(input_str, "quit")) {
                MainUI.registerSigninUi();
            }
            if (Objects.equals(input_str, "5")) {
                String[] input = CommentUI.loadForAdd();
                Controller.control(input_str, CommentUI.loadHelper(input, CourseCode));
                StudentProfessorUI.StuProPage();
            }
            if (Objects.equals(input_str, "6")) {
                String[] input = CommentUI.loadForEdit();
                Controller.control(input_str, CommentUI.loadHelper(input, CourseCode));
                StudentProfessorUI.StuProPage();
            }
            if (Objects.equals(input_str, "7")) {
                String[] input = CommentUI.loadForDelete();
                Controller.control(input_str, CommentUI.loadHelper(input, CourseCode));
                StudentProfessorUI.StuProPage();
            }
            if (Objects.equals(input_str, "8")) {
                String[] input = new String[0];
                Controller.control(input_str, CommentUI.loadHelper(input, CourseCode));
                StudentProfessorUI.StuProPage();
            }
            count = count + 1;
            CommentPage(CourseCode);
        }
    }
}
