public class Student extends User {
    int student_number;
    String student_name;
    Student(int student_number, String student_name){
        this.student_name = student_name;
        this.student_number = student_number;
    }
    void add_course(String course){}
}
