package basics;

/**
 An entity class basics.Course with course code and course created year.
 **/
public class Course {
    final String course_code;
    final String course_description;
    public String course_start_year;

    /** instantiate basics.Course objects
     * @param code course code
     * @param description the description for this course
     * @param year the start year for the course
     */
    public Course(String code, String description, String year){
        course_code = code;
        course_description = description;
        course_start_year = year;
    }
}