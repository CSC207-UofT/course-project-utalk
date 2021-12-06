package interfaceadaptor.presenter;

import entity.CoursePage;
import usecase.entityInfroTransfer.CoursePageInfoGenerator;

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
        return concatString(CoursePageInfoGenerator.professorList(coursePage));
    }

    /**
     * @return a long string containing all students
     */
    public static String studentPresenter(CoursePage coursePage) {
        return concatString(CoursePageInfoGenerator.studentList(coursePage));
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
