package entity;

import java.util.HashMap;
import java.util.Map;

/**
 An entity class basics.Course with course code and course created year.
 **/
public class Course {
    public final String courseCode;
    public final String courseDescription;
    public String courseStartYear;
    //I think we should make these instant variables and add getter/setter methods if required

    /** instantiate basics.Course objects
     * @param code course code
     * @param description the description for this course
     * @param year the start year for the course
     */
    public Course(String code, String description, String year){
        courseCode = code;
        courseDescription = description;
        courseStartYear = year;
    }
    //change the naming convention of this method and where you have used it
    /**
     * @return return a HashMap of course information containing course_code, course_description, course_start_year
     */
    public Map<String, Object> courseInfoGetter(){
        // this function transfer data to presenter
        Map<String, Object> mp = new HashMap<>(){};
        mp.put("code", this.courseCode);
        mp.put("description", this.courseDescription);
        mp.put("year", this.courseStartYear);
        return mp;
    }
    //this seems unnecessarily complex
}