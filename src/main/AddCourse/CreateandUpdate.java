package AddCourse;

public class CreateandUpdate {
    public void runaddcourse(String[] info_lst){
        AllcourseToUI help_create_course = new AllcourseToUI();
        if (help_create_course.add_course(info_lst[0], info_lst[1], info_lst[2])) {
            System.out.println("Course added successfully!");
        } else {
            System.out.println("Course cannot be added as you are not a faculty!");
        }
    }
    public void updatecourseinfo(String[] info_lst){
        AllcourseToUI help_create_course = new AllcourseToUI();
        if (help_create_course.update_course(info_lst[0], info_lst[1], info_lst[2])) {
            System.out.println("Course info updated successfully!");
        } else {
            System.out.println("Course info cannot be updated as you are not a faculty!");
        }

    }
}
