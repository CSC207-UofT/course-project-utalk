package basics;
import java.io.*;
import java.util.Iterator;


public class all_user_new {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("data_base.csv")) {
            register_new.register_user("id", "user_name", "password", "type", "status");
            register_new.register_user("111", "qiao", "Qiao123", "2", "true");
            register_new.register_user("1132", "qi31o", "Qia21323", "2", "False");
            register_new.register_user("1132", "qi13131o", "1231", "2", "Fa1se");
            register_new.register_user("1313432", "qi231o", "42423323", "2", "False");
            delete_user_new.remove_record("111");
            log_in_new.print_out_all_user();


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}