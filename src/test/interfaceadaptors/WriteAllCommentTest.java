package interfaceadaptors;

import entity.CoursePage;
import entity.Professor;
import interfaceadaptor.boundaries.DatabaseWriter;
import usecase.adddeleteeditcomment.CommentAdder;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCourses;

import java.util.HashMap;

public class WriteAllCommentTest {
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;

        Professor prof = new Professor("Professor", "a", "a");
        CourseEnroller.enrollCourse("csc207", prof);
        CommentAdder.addComment(prof, "csc207", "aho", 0);
        if(AllCourses.coursePageHashMap.get("csc207").getPost_page_List().get(0).comments.isEmpty()){
            System.out.println("lalalalala");
        }
        DatabaseWriter.writeComment();
    }

}
