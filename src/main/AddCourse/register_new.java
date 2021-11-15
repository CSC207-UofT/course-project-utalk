package basics;
import java.io.*;

import java.io.PrintWriter;


public class register_new {
    public static void register_user(String id, String user_name, String password, String type, String status){
        String file_path = "data_base.csv";
        try{
            FileWriter fw = new FileWriter(file_path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(String.valueOf(id) + ',' + user_name + ',' + password + ',' + String.valueOf(type) + ',' + status);
            pw.flush();
            pw.close();
            System.out.println("registered successfully!");

        }
        catch (Exception E)
        {
            System.out.println("Fail to register!");
        }
    }


}
