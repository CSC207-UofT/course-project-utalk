package interfaceadaptor.Presenter;

import entity.CoursePage;

import java.util.ArrayList;


/**
 * Present course member's list
 */
public class CourseMemberPresenter {
    /**
     * Return all professors in the coursePage.
     *
     * @param coursePage The coursePage we attach to.
     */
    public static String professorPresenter(CoursePage coursePage) {
        return concatString(coursePage.professorList());
    }

    /**
     * @return a long string containing all students
     */
    public static String studentPresenter(CoursePage coursePage) {
        return concatString(coursePage.studentList());
    }

    public static String concatString(ArrayList<String> lst) {
        String result = "";
        for (String std : lst) {
            result = result.concat(std);
            result = result.concat(", ");
        }
        return result;
    }

}
