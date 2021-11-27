package interface_adaptor.Presenter;

import entity.CoursePage;

/**
 * Present course member's list
 */
public class CourseMemberPresenter {
    /** Print all professors in the coursePage.
     * @param coursePage The coursePage we attach to.
     */
    public void ProfessorPresenter(CoursePage coursePage) {
        for (String prof: coursePage.professorList()) {
            System.out.print(prof);
            System.out.print(", ");
        }
    }

    /** Print all students in the coursePage
     * @param coursePage The coursePage we attach to.
     */
    public void StudentPresenter(CoursePage coursePage) {
        for (String std: coursePage.studentList()) {
            System.out.print(std);
            System.out.print(", ");
        }
    }

}
