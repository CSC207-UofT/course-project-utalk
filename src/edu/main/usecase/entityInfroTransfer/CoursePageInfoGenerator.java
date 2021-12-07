package usecase.entityInfroTransfer;

import entity.Course;
import entity.CoursePage;


import java.util.ArrayList;

public class CoursePageInfoGenerator {
    public static ArrayList<String> studentList(CoursePage cp) {
        return cp.studentList();
    }
    public static ArrayList<String> professorList(CoursePage cp) {
        return cp.professorList();
    }
    public static ArrayList<String> semesterList(CoursePage cp){
        return cp.semesterList();
    }
    public Course getCourse(CoursePage cp){
        return cp.course;
    }
    public String getInfoAdd(CoursePage cp){
        return cp.info_added;
    }
}
