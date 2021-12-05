package interfaceadaptor.boundaries;

import interfaceadaptor.gateways.CSVWriter;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;
import entity.CoursePage;
import entity.PostPage;


import java.util.ArrayList;

import static outerlayer.userinterface.FilePathHelper.FILEPATH;

public class DatabaseWriter {
    public static void writeAllCourses(){
        ArrayList<ArrayList<String>> courses = AllCourses.recordCourses();
        CSVWriter.write_to_csv(courses, FILEPATH + "/courses.csv");
    }

    public static void writeCommentableUser(){
        ArrayList<ArrayList<String>> userCourse = AllCommentableUser.recordCommentableUser();
        CSVWriter.write_to_csv(userCourse, FILEPATH + "/commentableuser.csv");
    }

    public static void writeComment(){
        ArrayList<ArrayList<String>> comments =  new ArrayList<>();
        for(CoursePage coursepage : AllCourses.getCoursePageHashMap().values()){
            for(PostPage postpage: coursepage.post_page_List){
                ArrayList<ArrayList<String>> comment = postpage.recordComments();
                comments.addAll(comment);}

        } CSVWriter.write_to_csv(comments, FILEPATH + "/comments.csv");


    }

    public static void writeAll(){
        writeAllCourses();
        writeCommentableUser();
        writeComment();
    }

}
