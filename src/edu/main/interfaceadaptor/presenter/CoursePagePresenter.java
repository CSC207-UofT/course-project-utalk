package interfaceadaptor.presenter;

import entity.CommentableUser;
import entity.CoursePage;
import usecase.entityInfroTransfer.CourseInfoGetter;
import usecase.entityInfroTransfer.CoursePageInfoGenerator;

import java.util.Map;

import static outerlayer.userinterface.FilePathHelper.FILEPATH;

/**
 * Present the CoursePage
 */
public class CoursePagePresenter implements GeneralPrinter {
    static final String file_name = FILEPATH + "course page data.txt";
    static public CoursePage cour;

    /**
     * Present all course semesters
     */
    public static void semesterPresenter() {
        try {
            for (String semester : CoursePageInfoGenerator.semesterList(cour)) {
                System.out.print(semester + ", ");
            }
        } catch (Exception e){
                System.out.print("Please double check semester");
            }
    }

    public static void pagePresenter(String semester) {
        try {
            PostPagePresenter.pagePrinter(CoursePageInfoGenerator.postPageHashMap(cour).get(semester));
        } catch (Exception ex) {
            System.out.print("Please double check the semester information.");
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
        cour = CourseInfoGetter.courseGetter(course);
        if (cour == null) {
            System.out.print("Please first create the course.");
        } else {
            CoursePageInfoGenerator cpi = new CoursePageInfoGenerator();
            Map<String, Object> info_map =cpi.getCourse(cour).courseInfoGetter();
            RecordAndPresent.recordAndPresent("Course: " + info_map.get("code") + "\n" + "Year: " + info_map.get("year"), file_name);
            RecordAndPresent.recordAndPresent("\n======================================================================\n", file_name);
            RecordAndPresent.recordAndPresent("Professor(s): \n", file_name);
            RecordAndPresent.recordAndPresent(CourseMemberPresenter.professorPresenter(cour) + '\n', file_name);
            RecordAndPresent.recordAndPresent("Student(s): \n", file_name);
            RecordAndPresent.recordAndPresent(CourseMemberPresenter.studentPresenter(cour) + '\n', file_name);
            RecordAndPresent.recordAndPresent("Course Information: ", file_name);
            RecordAndPresent.recordAndPresent(info_map.get("description") + "\n", file_name);
            RecordAndPresent.recordAndPresent(cpi.getInfoAdd(cour) + '\n', file_name);
            RecordAndPresent.recordAndPresent("This year's current post page:", file_name);
            // print the sessions of course page
            pagePresenter(CoursePageInfoGenerator.semesterList(cour).get(CoursePageInfoGenerator.getLength(cour)-1));
            System.out.println("This course have following semesters: \n");
        }

    }
}
