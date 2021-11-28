package interfaceadaptor.Presenter;
import entity.CoursePage;
import entity.Professor;
import usecase.javastorage.AllCourses;


import java.util.Map;

/**
 * Present the CoursePage
 */
public class CoursePagePresenter {
    /** Present coursePage including course information and comments.
     * @param course The name of course we want to present
     */
    public void coursePresenter(String course) {
        CoursePage cour = AllCourses.coursePageHashMap.get(course);
        Map<String, Object> info_map = cour.course.courseInfoGetter();
        System.out.println("Course: " + info_map.get("code") + "\n" + "Year: " + info_map.get("year"));
        System.out.println("======================================================================\n");
        System.out.println("Professor(s): \n");
        for (Professor prof: cour.professor_list) {
            System.out.println(prof.getUserName() + ", ");
        }
        System.out.println("Course Information");
        System.out.println(info_map.get("description") + "\n");
        System.out.println(cour.info_added);
        CommentPrint commentPrint = new CommentPrint();
        commentPrint.pagePrinter(cour.getPostPage(-1));
    }
}
