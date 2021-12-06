package usecase.entityInfroTransfer;

import entity.CoursePage;
import entity.Professor;
import entity.Student;

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
}
