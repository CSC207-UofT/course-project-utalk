package basics;

import java.io.*;
import java.util.Scanner;

public class delete_user_new {
    public static String file_path = "data_base.csv";
    public static void delete_all_user(){
        try {
            FileWriter fw = new FileWriter(file_path, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
