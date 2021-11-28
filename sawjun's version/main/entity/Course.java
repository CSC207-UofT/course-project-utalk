package main.entity;

/**
 An entity class main.entity.Course with course code and course created year.
 **/
public class Course {
    private final String courseCode;
    private String courseDescription;
    private final String courseStartYear;

    /** instantiate main.entity.Course objects
     * @param code course code
     * @param description the description for this course
     * @param year the start year for the course
     */
    public Course(String code, String description, String year){
        this.courseCode = code;
        this.courseDescription = description;
        this.courseStartYear = year;
    }
    public String getCourseCode(){
        return this.courseCode;
    }
    public String getCourseDescription(){
        return this.courseDescription;
    }
    public String getCourseStartYear(){
        return this.courseStartYear;
    }
}