package usecase.userfactory;
import entity.Faculty;
import entity.Professor;
import entity.Student;
import entity.User;

import java.util.Objects;

public class UserFactory {
    /**
     * @param info the String[] of information including user id, name, password, type.
     * @return a specific subtype of User.
     */
    public static User create(String[] info){
        if (Objects.equals(info[3], "student")){
            return new Student(info[0], info[1], info[2]);
        } else if  (Objects.equals(info[3], "professor")){
            return new Professor(info[0], info[1], info[2]);
        } else{
            return new Faculty(info[0], info[1], info[2]);
        }
    }
}
