package use_case;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Register_user {
    public static String file_path = "data_base.csv";

    public static void register_user(String id, String user_name, String password, String type, String status){
        //This method register a new user into the database file.

        try{
            FileWriter fw = new FileWriter(file_path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(String.valueOf(id) + ',' + user_name + ',' + password + ',' + String.valueOf(type) + ',' + status);
            pw.flush();
            pw.close();

        }
        catch (Exception E)
        {
            System.out.println("Fail to register!");
        }
    }


}
