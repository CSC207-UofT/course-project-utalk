/**
 An entity class Course with course code and course created year.
 **/
public class Course {
    private final String course_code;
    private String course_description;
    public String course_start_year;

    /** instantiate Course objects
     * @param code course code
     * @param description the description for this course
     * @param year the start year for the course
     */
    Course(String code, String description, String year){
        course_code = code;
        course_description = description;
        course_start_year = year;
    }
    public String getCourse_code(){
        return this.course_code;
    }
}