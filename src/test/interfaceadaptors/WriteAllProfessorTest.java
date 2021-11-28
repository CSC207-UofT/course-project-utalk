

package interfaceadaptors;

import entity.Professor;
import interfaceadaptor.boundaries.DatabaseWriter;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCourses;
import usecase.javastorage.AllProfessors;

public class WriteAllProfessorTest {
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc200", "a course", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 2;
        Professor professor = new Professor("16", "Caroline", "207");
        AllProfessors.ProfessorHashMap.put(professor.user_name, professor);
        CourseEnroller.teachingCourse("csc207", professor);
        CourseEnroller.teachingCourse("csc200", professor);
        DatabaseWriter.writeProfessorCourses();
    }
}
