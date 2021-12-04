import interfaceadaptor.readers.AllReader;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

public class AllReaderTest {
    public static void main(String[] args){
        AllReader.readAll();
        assert ! AllCourses.coursePageHashMap.isEmpty();
        assert ! AllCommentableUser.getAllCommentableUsers().isEmpty();
        assert ! AllCourses.coursePageHashMap.get("csc207").getPost_page_List().get(0).comments.isEmpty();
    }
}
