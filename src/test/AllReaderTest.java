import interfaceadaptor.AllReader;
import usecase.javastorage.AllCourses;
import usecase.javastorage.AllProfessors;
import usecase.javastorage.AllStudents;

public class AllReaderTest {
    public static void main(String[] args){
        AllReader.readAll();
        assert ! AllCourses.coursePageHashMap.isEmpty();
        assert ! AllProfessors.ProfessorHashMap.isEmpty();
        assert ! AllStudents.StudentHashMap.isEmpty();
        assert ! AllCourses.coursePageHashMap.get("csc207").getPost_page_List().get(0).comments.isEmpty();
    }
}
