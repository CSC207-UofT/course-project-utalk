package interfaceadaptor.boundaries;

import interfaceadaptor.CSVWriter;
import usecase.javastorage.AllCourses;
import usecase.javastorage.AllProfessors;
import usecase.javastorage.AllStudents;
import entity.CoursePage;
import entity.PostPage;


import java.util.ArrayList;

public class DatabaseWriter {
    public static void writeAllCourses(){
        ArrayList<ArrayList<String>> courses = AllCourses.recordCourses();
        CSVWriter.write_to_csv(courses, "courses.csv");
    }
    public static void writeStudentCourses(){
        ArrayList<ArrayList<String>> studentCourse = AllStudents.recordStudent();
        CSVWriter.write_to_csv(studentCourse, "students.csv");
    }

    public static void writeProfessorCourses(){
        ArrayList<ArrayList<String>> professorCourse = AllProfessors.recordProfessor();
        CSVWriter.write_to_csv(professorCourse, "professors.csv");
    }

    public static void writeComment(){
        ArrayList<ArrayList<String>> comments =  new ArrayList<>();
        for(CoursePage coursepage : AllCourses.getCoursePageHashMap().values()){
            for(PostPage postpage: coursepage.post_page_List){
                ArrayList<ArrayList<String>> comment = postpage.recordComments();
                comments.addAll(comment);}

        } CSVWriter.write_to_csv(comments, "comments.csv");


    }

}
