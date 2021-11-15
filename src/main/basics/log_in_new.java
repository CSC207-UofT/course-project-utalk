package basics;

import AddCourse.GetCourseUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class log_in_new {
    static String file_path = "data_base.csv";
    public static register_new register_new = new register_new();


    public static void log_in(){
        ArrayList<ArrayList<String>> current_file = register_new.csv_to_list();
        System.out.println("What is your username?");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        ArrayList<String> current_username = new ArrayList<>();
        for (ArrayList<String> user: current_file){
            current_username.add(user.get(1));
        }
        if (current_username.contains(username)){
            //this user has registered before.
            System.out.println("Please type in your password.");
            String password = scan.nextLine();
            for(ArrayList<String> user: current_file){
                if (user.get(1).equals(username)){
                    //we have found this user.
                    if (user.get(2).equals(password)){
                        //password correct. change status.
                        System.out.println("Log in successfully");
                        Status.read_status();
                    }
                    else{
                        //password incorrect
                        System.out.println("Sorry, password incorrect. Please type in password again or type '\\q' to go back to main menu.");
                        String password2 = scan.nextLine();
                        do{
                            System.out.println("Sorry, password incorrect. Please type in password again or type '\\q' to go back to main menu.");
                            password2 = scan.nextLine();
                        }
                        while((! password2.equals(user.get(2))) && (! password2.equals("\\q")));
                        if (password2.equals("\\q")){
                            commandUI_new.register_signin_ui();
                        }
                        else if(password2.equals(user.get(2))){
                            // password correct at last.
                            System.out.println("Log in successfully");
                            Status.read_status();

                        }


                    }
                }
            }

        }
        else{
            //This user has not registered before.
            System.out.println("You have not registered yet. Please register first.");
            commandUI_new.register_signin_ui();
        }


    }

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
