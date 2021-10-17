import java.util.Objects;
import java.util.Scanner;

/**
 * A beautiful user interface for logging in.
 */
public class CommandLineUI {
    public void runLogin(LoginController controller) {
        boolean flag = true;
        while (flag) {
            System.out.println("Usertype: \n Please enter either faculty, officer, or student.");
            Scanner scan = new Scanner(System.in);
            String type = scan.nextLine();
            System.out.println("Are you new user? \n Please enter yes or no: ");
            String judge = scan.nextLine();
            System.out.println("Please enter user name:");
            String name = scan.nextLine();
            System.out.println("Please enter utorid:");
            String id = scan.nextLine();
            System.out.println("Please enter password:");
            String key = scan.nextLine();
            if (Objects.equals(judge, "no")) {
                controller.runLogin(type, name, id, key);
            } else if (Objects.equals(judge, "yes")) {
                controller.register(type, name, id, key);
            }
            System.out.println("Will you logout？Please enter yes or no: ");
            String flag_text = scan.nextLine();
            if (flag_text.equals("yes")) {
                flag = false;
            }
        }
    }


}