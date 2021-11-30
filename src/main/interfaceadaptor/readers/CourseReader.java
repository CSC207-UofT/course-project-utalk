package interfaceadaptor.readers;

import interfaceadaptor.CsvReader;
import usecase.createupdate.CourseCreator;
import usecase.createupdate.CourseUpdater;

import java.util.ArrayList;

public class CourseReader {
    public static void readCourse(){
        ArrayList<ArrayList<String>> courses = CsvReader.readCsv(
                "/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/" +
                        "database/courses.csv");
        for (ArrayList<String> course: courses){
            CourseCreator.createCourse(course.get(0), course.get(1), course.get(2));
            CourseUpdater.updateCourseInfo(course.get(0), course.get(3), course.get(4));
        }
    }
}
