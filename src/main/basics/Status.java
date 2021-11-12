package basics;

import AddCourse.Faculty;

import java.util.ArrayList;
import java.util.Objects;

public class Status {
    public static User user;

    public Status() {
        ArrayList<ArrayList<String>> new_lst = register_new.csv_to_list();
        for (ArrayList<String> member : new_lst){
            if (Objects.equals(member.get(4), "TRUE")){
                if (Objects.equals(member.get(3), "Faculty")){
                    user = new Faculty(member.get(0), member.get(1), member.get(2));
                }
                else if(Objects.equals(member.get(3), "Student")){
                    user = new Student(member.get(0), member.get(1), member.get(2));
                } else{
                    user = new Professor(member.get(0), member.get(1), member.get(2));
                }
            }
        }
    }
}
