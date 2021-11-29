package interfaceadaptor.Presenter;
import entity.CoursePage;
import entity.Professor;
import interfaceadaptor.TextFileCreator;
import usecase.javastorage.AllCourses;

import java.util.HashMap;
import java.util.Map;

/**
 * Present the CoursePage
 */
public class CoursePagePresenter {
    static final TextFileCreator tfc = new TextFileCreator();
    static final RecordAndPresent recordAndPresent = new RecordAndPresent();
    static final String file_name = "D:\\2021Fall\\CSC207\\IdeaProjects\\course-project-utalk\\src\\main\\outerlayer\\database\\course page data.txt";
    /** Present coursePage including course information and comments.
     * @param course The name of course we want to present
     */
    public void coursePresenter(String course ,String semester) {
        CoursePage cour = AllCourses.coursePageHashMap.get(course);
        Map<String, Object> info_map = cour.course.courseInfoGetter();
        recordAndPresent.recordAndPresent("Course: " + info_map.get("code") + "\n" + "Year: " + info_map.get("year"), file_name);
        recordAndPresent.recordAndPresent("\n======================================================================\n", file_name);
        CourseMemberPresenter cmp = new CourseMemberPresenter();
        recordAndPresent.recordAndPresent("Professor(s): \n", file_name);
        recordAndPresent.recordAndPresent(cmp.professorPresenter(cour) + '\n', file_name);
        recordAndPresent.recordAndPresent("Student(s): \n", file_name);
        recordAndPresent.recordAndPresent(cmp.studentPresenter(cour) + '\n', file_name);
        recordAndPresent.recordAndPresent("Course Information: ", file_name);
        recordAndPresent.recordAndPresent(info_map.get("description") + "\n", file_name);
        recordAndPresent.recordAndPresent(cour.info_added + '\n', file_name);
        CommentPrinter commentPrint = new CommentPrinter();
        commentPrint.pagePrinter(cour.getPostPage(semester));
        commentPrint.courseCommentPresenter(course, semester);
    }

    /** Present all course semesters
     * @param course the course
     */
    public static void semesterPresenter(String course) {
        CoursePage cour = AllCourses.coursePageHashMap.get(course);
        for(String semester: cour.semesterList()){
            System.out.print(semester);
        }
    }
}
