package outerlayer.userinterface.facultyuserinterface;

import java.io.InputStream;
import java.util.Scanner;

public class GetInputIn {
    /* this method is used to help turn the inputstream into Scanner type to help with the string construction. */
    public Scanner getInput(InputStream stream){
        return new Scanner(System.in);
    }
}
