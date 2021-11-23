package use_case;

import entity.Faculty;
import entity.Professor;
import entity.Student;
import entity.User;
import interface_adaptor.ReadCsv;
import interface_adaptor.boundaries.ReadIn;
import outer_layer.UI.FacultyUI.FacultyUI;
import outer_layer.UI.GetMethod;
import outer_layer.UI.ProfessorUI.ProfessorUI;
import outer_layer.UI.StudentUI.StudentUI;

import java.util.ArrayList;
import java.util.Objects;

public class Status {
    public static User user;
    public static ReadIn invert;
    public static GetMethod read_status() {
        /* precondition: there is one person logged and exactly one "true" in the status column
         */
        // TODO: fix this based on the new csv_to_list
        // TODO: explain why we do not throw exceptions
        invert = new ReadCsv();
        ArrayList<ArrayList<String>> new_lst = invert.csv_to_list("user.csv");
        for (ArrayList<String> member : new_lst){
            if (Objects.equals(member.get(4), "true")){
                if (Objects.equals(member.get(3), "Faculty")){
                    user = new Faculty(member.get(0), member.get(1), member.get(2));
                    return (GetMethod) new FacultyUI();
                }
                else if(Objects.equals(member.get(3), "Student")){
                    user = new Student(member.get(0), member.get(1), member.get(2));
                    return (GetMethod) new StudentUI();
                } else{
                    user = new Professor(member.get(0), member.get(1), member.get(2));
                    return (GetMethod) new ProfessorUI();
                }
            }
        }
    return null;}
}
