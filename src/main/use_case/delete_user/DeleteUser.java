package use_case.delete_user;

import java.io.FileWriter;
import java.io.IOException;

public class DeleteUser {
    public static String file_path = "data_base.csv";
    public static void delete_all_user() {
        //This function will delete all recorded users in user database.
        try {
            FileWriter fw = new FileWriter(file_path, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
