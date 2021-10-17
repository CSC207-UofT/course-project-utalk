

class Manager{
    public static void main(String[] args){
        AllStudent student = new AllStudent();
        LoginUseCase useCase = new LoginUseCase(student); //use case
        LoginController controller = new LoginController(useCase);
        CommandLineUI ui = new CommandLineUI();
        ui.runLogin(controller);
        System.out.println(AllStudent.students);
        ui.runLogin(controller);
    }

}
