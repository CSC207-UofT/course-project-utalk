import interfaceadaptor.AllReader;
import usecase.javastorage.AllCourses;
import usecase.javastorage.AllProfessors;
import usecase.javastorage.AllStudents;

public class AllReaderTest {
    public static void main(String[] args){
        AllReader.readAll();
        assert ! AllCourses.coursePageHashMap.isEmpty();
        assert ! AllProfessors.ProfessorHashMap.isEmpty();
        assert ! AllStudents.StundetHashMap.isEmpty();
    }
}
