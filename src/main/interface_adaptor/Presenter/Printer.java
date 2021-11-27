package interface_adaptor.Presenter;

import entity.PostPage;

import entity.Comment;
import entity.Professor;
import entity.Student;


/**
 * Printer class contains all print function for Student, Professor.
 */
public class Printer {
    private final CommentPrint printer = new CommentPrint();

    /** Print professor's comments on specific course
     * @param course the name of the course
     * @param professor the professor variable
     */
    public void ProfessorCommentPresenter(String course, Professor professor) {
        if (professor.getCourseComments(course) != null) {
            for (Comment comment : professor.getCourseComments(course)) {
                printer.CommentPrinter(comment, 0);
            }
        }
    }
    /** Print student's comments on specific course
     * @param course the name of the course
     * @param student the student variable
     */
    public void StudentCommentPresenter(String course, Student student) {
        for(Comment comment: student.getCourseComments(course)) {
            printer.CommentPrinter(comment, 0);
        }
    }
    
}
