package usecase.deleteuser;

import outerlayer.userinterface.FilePathHelper;

import java.io.FileWriter;
import java.io.IOException;

public class UserDeleter {
    public static String file_path = FilePathHelper.FILEPATH + "/user.csv";

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
