package AddCourse;

import basics.Status;

public class AllcourseToUI {
    public AllcourseToUI() {
    }

    public boolean add_course(String code, String info, String year) {
        if (Status.user instanceof Faculty) {
            ((Faculty)Status.user).creat_course(code, info, year);
            return true;
        } else {
            return false;
        }
    }

    public boolean update_course(String code, String info, String year){
        if (Status.user instanceof Faculty) {
            ((Faculty)Status.user).update_course_info(code, info, year);
            return true;
        } else {
            return false;
        }
    }
}