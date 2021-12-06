package interfaceadaptor.presenter;

import entity.CommentableUser;
import entity.CoursePage;
import interfaceadaptor.gateways.TextFileCreator;
import usecase.entityInfroTransfer.CoursePageInfoGenerator;
import usecase.javastorage.AllCourses;

import java.util.Map;

import static outerlayer.userinterface.FilePathHelper.FILEPATH;

/**
 * Present the CoursePage
 */
public class CoursePagePresenter implements GeneralPrinter {
    static final TextFileCreator tfc = new TextFileCreator();
    static final String file_name = FILEPATH + "course page data.txt";
    static public CoursePage cour;

    /**
     * Present all course semesters
     */
    public static void semesterPresenter() {
        for (String semester : CoursePageInfoGenerator.semesterList(cour)) {
            System.out.print(semester);
        }
    }

    public static void pagePresenter(String semester) {
        try {
            PostPagePresenter.pagePrinter(cour.postPageHashMap().get(semester));
        } catch (Exception ex) {
            System.out.print("Please double check the semester.");
        }
    }

    @Override
    public void presenterRequiresUserInfo(String course, CommentableUser commentableUser) {
    }

    /**
     * Present coursePage including course information and comments.
     *
     * @param course The name of course we want to present
     */
    @Override
    public void generalPresenter(String course) {
        cour = AllCourses.coursePageHashMap.get(course);
        if (cour == null) {
            System.out.print("Please first create the course.");
        } else {
            Map<String, Object> info_map = cour.course.courseInfoGetter();
            RecordAndPresent.recordAndPresent("Course: " + info_map.get("code") + "\n" + "Year: " + info_map.get("year"), file_name);
            RecordAndPresent.recordAndPresent("\n======================================================================\n", file_name);
            RecordAndPresent.recordAndPresent("Professor(s): \n", file_name);
            RecordAndPresent.recordAndPresent(CourseMemberPresenter.professorPresenter(cour) + '\n', file_name);
            RecordAndPresent.recordAndPresent("Student(s): \n", file_name);
            RecordAndPresent.recordAndPresent(CourseMemberPresenter.studentPresenter(cour) + '\n', file_name);
            RecordAndPresent.recordAndPresent("Course Information: ", file_name);
            RecordAndPresent.recordAndPresent(info_map.get("description") + "\n", file_name);
            RecordAndPresent.recordAndPresent(cour.info_added + '\n', file_name);
            RecordAndPresent.recordAndPresent("\n", file_name);
            // print the sessions of course page
            System.out.println("This course have following semesters: \n");
            semesterPresenter();
        }

    }
}
