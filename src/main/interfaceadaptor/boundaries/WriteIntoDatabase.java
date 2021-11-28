package interfaceadaptor.boundaries;

import usecase.javastorage.AllCourses;

import java.util.ArrayList;

public class WriteIntoDatabase {
    public static void writeAllCourses(){
        ArrayList<ArrayList<String>> courses = AllCourses.recordCourses();
        interface_adaptor.CSVWriter.write_to_csv(courses, "/Users/hanqizhang/Desktop/CSC207/course-project-utalk1/src/main/outerlayer/database/courses.csv");
    }
}
