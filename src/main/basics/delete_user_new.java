package basics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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

=======
    public static String file_path = "data_base.txt";
    static Scanner scanner;
    public static void remove_record(String remove_user_name){
        String temp_file = "temp.csv";
        File old_file = new File(file_path);
        File new_file = new File(temp_file);
        String id = ""; String username = ""; String password = ""; String type = ""; String status = "";
        try{
            FileWriter fw = new FileWriter(temp_file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            scanner = new Scanner(new File(file_path));
            scanner.useDelimiter("[,\n]");

            while(scanner.hasNext())
            {
                id = scanner.next();
                username = scanner.next();
                password = scanner.next();
                type = scanner.next();
                status = scanner.next();
                if (!username.equals(remove_user_name)){
                    pw.println(id + ',' + username + ',' + password + ',' + type + ',' + status);
                }

            }
            scanner.close();
            pw.flush();
            pw.close();
            old_file.delete();
            File dump = new File(file_path);
            new_file.renameTo(dump);

        }
        catch(Exception e){
            System.out.println("error");
        }
    }
