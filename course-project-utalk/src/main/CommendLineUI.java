import java.util.Scanner;

/**
 * A user interface for logging in and classify user type: Faculty, Student, Professor
 */

public class CommendLineUI {
    public void runLogin(LogController controller) {
        System.out.println("Usertype: \n Please enter either Faculty, Officer, or Student.");
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        System.out.println("Please enter user name:");
        String name = scan.nextLine();
        System.out.println("Please enter password:");
        String key = scan.nextLine();
        controller.Login(type, name, key);



    }


}
