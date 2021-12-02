package interfaceadaptor.Presenter;
import entity.CoursePage;
import interfaceadaptor.TextFileCreator;
import usecase.javastorage.AllCourses;
import java.util.Map;

/**
 * Present the CoursePage
 */
public class CoursePagePresenter {
    static final TextFileCreator tfc = new TextFileCreator();
    static final RecordAndPresent recordPresent = new RecordAndPresent();
    static final CommentPrinter commentPrint = new CommentPrinter();
    static final String file_name = "course page data.txt";
    static public CoursePage cour;

    /** Present coursePage including course information and comments.
     * @param course The name of course we want to present
     */
    public void coursePresenter(String course) {
        cour = AllCourses.coursePageHashMap.get(course);
        Map<String, Object> info_map = cour.course.courseInfoGetter();
        recordPresent.recordAndPresent("Course: " + info_map.get("code") + "\n" + "Year: " + info_map.get("year"), file_name);
        recordPresent.recordAndPresent("\n======================================================================\n", file_name);
        CourseMemberPresenter cmp = new CourseMemberPresenter();
        recordPresent.recordAndPresent("Professor(s): \n", file_name);
        recordPresent.recordAndPresent(cmp.professorPresenter(cour) + '\n', file_name);
        recordPresent.recordAndPresent("Student(s): \n", file_name);
        recordPresent.recordAndPresent(cmp.studentPresenter(cour) + '\n', file_name);
        recordPresent.recordAndPresent("Course Information: ", file_name);
        recordPresent.recordAndPresent(info_map.get("description") + "\n", file_name);
        recordPresent.recordAndPresent(cour.info_added + '\n', file_name);
        // print the sessions of course page
        semesterPresenter();
    }


    /** Present all course semesters
     */
    public void semesterPresenter() {
        for(String semester: cour.semesterList()){
            System.out.print(semester);
        }
    }

    public void pagePresenter(String semester) {
        PostPagePresenter pp = new PostPagePresenter();
        pp.pagePrinter(cour.postPageHashMap().get(semester));
    }
}
