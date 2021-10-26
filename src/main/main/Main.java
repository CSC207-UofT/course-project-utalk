package main;

public class Main {

    public static void main(String[] args) {
        AllStudent student = new AllStudent();
        LoginUser useCase = new LoginUser(student); //use case
        Signup controller = new Signup(useCase);
        CommandLineUI ui = new CommandLineUI(); //UI
        ui.runLogin(controller);
    }
}
