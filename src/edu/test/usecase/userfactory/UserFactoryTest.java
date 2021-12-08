package usecase.userfactory;

import entity.Faculty;
import entity.Professor;
import entity.Student;

public class UserFactoryTest {
    public static void main(String[] args){

        int size = 4;
        String[] studentinfo = new String[size];
        studentinfo[0] = "1";
        studentinfo[1] = "Judd";
        studentinfo[2] = "123";
        studentinfo[3] = "student";

        boolean isStudent = UserFactory.create(studentinfo) instanceof Student;
        System.out.println(isStudent);

        String[] professorinfo = new String[size];
        professorinfo[0] = "2";
        professorinfo[1] = "Paul";
        professorinfo[2] = "123";
        professorinfo[3] = "professor";

        boolean isProfessor = UserFactory.create(professorinfo) instanceof Professor;
        System.out.println(isProfessor);

        String[] facultyinfo = new String[size];
        facultyinfo[0] = "2";
        facultyinfo[1] = "Paul";
        facultyinfo[2] = "123";
        facultyinfo[3] = "Faculty";

        boolean isFaculty = UserFactory.create(facultyinfo) instanceof Faculty;
        System.out.println(isFaculty);
    }

}
