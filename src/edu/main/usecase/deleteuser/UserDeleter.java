package usecase.deleteuser;

import java.io.FileWriter;
import java.io.IOException;

public class UserDeleter {
    public static String file_path = "data_base.csv";

    /**
     * This function will delete all recorded users in user database.
     */
    public static void deleteAllUser() {
        try {
            FileWriter fw = new FileWriter(file_path, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
