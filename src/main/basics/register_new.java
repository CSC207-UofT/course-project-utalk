package basics;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class register_new implements InvertStatus{

    public static String file_path = "data_base.csv";
    static int ID = 0;

    public static void register_ui(){
        ID = ID + 1;
        register_new register_new = new register_new();
        ArrayList<ArrayList<String>> current_list = register_new.csv_to_list();
        System.out.println("Please enter your new user name. or enter 'quit' to go back to main menu.");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        if(username.equals("quit")){
            //quit to main menu
            commandUI_new.register_signin_ui();
        }
        // Now we want to check whether this username already exists or not.
        ArrayList<String> user_name_list = new ArrayList<>();
        for(ArrayList<String> item: current_list){
            user_name_list.add(item.get(1));
        }

        if (user_name_list.contains(username)){
            System.out.println("This user name already exist. Please sign in or change another username.");
            System.out.println("================================================================================================================================");
            register_ui();
        }
        else{
            //Valid username. Now ask for password.
            System.out.println("Please enter password.");
            String password1 = scan.nextLine();
            System.out.println("Please re-enter password");
            String password2 = scan.nextLine();
            if (password1.equals(password2)) {
                while (true) {
                    System.out.println("What is your identity?");
                    System.out.println("1: student. 2: professor. 3: faculty");
                    Scanner sc = new Scanner(System.in);
                    String type = sc.nextLine();
                    switch (type) {
                        case "1":
                        case "student": {
                            long randomID = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
                            //This code does not check whether this ID existed before or not.

                            register_user("1", username, password1, "Student", "true");
                            System.out.println("You have successfully sign up as student \"" + username + "\"");
                            commandUI_new.register_signin_ui();
                            break;
                        }

                        case "2":
                        case "professor": {
                            long randomID = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
                            //This code does not check whether this ID existed before or not.

                            register_user("12", username, password1, "Professor", "true");
                            System.out.println("You have successfully sign up as professor \"" + username + "\"");
                            commandUI_new.register_signin_ui();
                            break;

                        }
                        case "3":
                        case "faculty": {
                            long randomID = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
                            //This code does not check whether this ID existed before or not.

                            register_user("123", username, password1, "Faculty", "true");
                            System.out.println("You have successfully sign up as faculty \"" + username + "\"");
                            commandUI_new.register_signin_ui();
                            break;

                        }
                        default: {
                            System.out.println("this is not a valid input. please re-enter.");
                            System.out.println("\n================================================================================================================================");
                        }
                    }
                }
            }


            else{
                System.out.println("You have entered different password. Request denied.");
                System.out.println("================================================================================================================================");
                register_new.register_ui();
            }
        }

    }
    public static ArrayList<String> str_to_arraylist(String string, String split_by){
        ArrayList<String> result = new ArrayList<>();
        for (String item : string.split(",")){
            result.add(item);
        }
        return result;
    }

    @Override
    public ArrayList<ArrayList<String>> csv_to_list(){
        //Transfer a csv file into readable List<List<String>>. Each sublist is a row from the csv file.
        String line = "";
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            while((line = br.readLine()) != null){
                result.add(str_to_arraylist(line, ","));
                //result.add(Collections.singletonList(line));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void list_to_csv(List<List<String>> list) {
        /*
        This function will renew the database file by that List<List<String>>.
         */
        delete_user_new.delete_all_user();
        int i = 0;
        if (list == null || list.size() == 0) {
            System.out.println("This list is empty or null.");
        } else {
            while (list.get(i) != null) {
                register_user(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3), list.get(i).get(4));
                i += 1;
            }
        }
    }

    public static void register_user(String id, String user_name, String password, String type, String status){

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
