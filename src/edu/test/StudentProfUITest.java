import entity.Student;
import interfaceadaptor.loginlogout.Login;
import outerlayer.userinterface.studentprofessorinterface.StudentProfessorUI;
import usecase.createupdate.CourseCreator;

public class StudentProfUITest {
    public static void main(String[] agrs){
        Login.loggedInUser = new Student("hello", "1", "1");
        CourseCreator.createCourse("csc207", "hello", "hello");
        StudentProfessorUI.StuProPage();
    }
}
