package interfaceadaptors;

import entity.Professor;
import entity.Student;
import interfaceadaptor.boundaries.DatabaseWriter;
import interfaceadaptor.presenter.CommentableUserPresenter;
import interfaceadaptor.presenter.CoursePagePresenter;
import usecase.adddeleteeditcomment.CommentAdder;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCourses;

public class CommentPresenterTest {
    // we didn't use Junit test as we need to run to see output
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        Student student = new Student("hello", "1", "1");
        Professor prof = new Professor("Professor", "a", "a");
        CourseEnroller.enrollCourse("csc207", prof);
        CourseEnroller.enrollCourse("csc207", student);
        CommentAdder.addComment(prof, "csc207", "aho", 0);
        CommentAdder.addComment(prof, "csc207", "keep working!", 1);
        CommentAdder.addComment(prof, "csc207", "You will learn more", 2);
        CommentAdder.addComment(student, "csc207", "Hi professor", 1);
        CommentAdder.addComment(student, "csc207", "Nice to meet every one here", 0);
        CommentAdder.addComment(student, "csc207", "I will do that", 3);
        CommentableUserPresenter.commentableUserCourseListPresenter(student);
        CommentableUserPresenter cup = new CommentableUserPresenter();
        cup.presenterRequiresUserInfo("csc207", student);
        CoursePagePresenter cpp = new CoursePagePresenter();
        cpp.generalPresenter("csc207");
        cpp.generalPresenter("csc200");
        if(AllCourses.coursePageHashMap.get("csc207").getPost_page_List().get(0).comments.isEmpty()){
            System.out.println("lalalalala");
        }
        DatabaseWriter.writeComment();
    }
}
