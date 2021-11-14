package basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class log_in_new {
    static String file_path = "data_base.csv";

    public static void print_out_all_user(){
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            while((line = br.readLine()) != null){
                System.out.println(line);

            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
