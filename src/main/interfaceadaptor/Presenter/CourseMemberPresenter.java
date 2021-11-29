package interfaceadaptor.Presenter;

import entity.CoursePage;

/**
 * Present course member's list
 */
public class CourseMemberPresenter {
    /** Print all professors in the coursePage.
     * @param coursePage The coursePage we attach to.
     */
    public String professorPresenter(CoursePage coursePage) {
        String result = "";
        for (String prof: coursePage.professorList()) {
            result = result.concat(prof);
            result = result.concat(",");
        }
        return result;
    }

    /**
     * @return a long string containing all students
     */
    public String studentPresenter(CoursePage coursePage) {
        String result = "";
        for (String std: coursePage.studentList()) {
            result = result.concat(std);
            result = result.concat(",");
        }
        return result;
    }

}
