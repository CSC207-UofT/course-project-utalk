public class Main {

    public static void main(String[] args) {
        AllStudent student = new AllStudent();
        LoginUseCase useCase = new LoginUseCase(student); //use case
        LoginController controller = new LoginController(useCase); //controller
        CommandLineUI ui = new CommandLineUI(); //UI
        ui.runLogin(controller);
    }
}
