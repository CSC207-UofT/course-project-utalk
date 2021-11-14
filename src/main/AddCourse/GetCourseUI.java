package AddCourse;



public class GetCourseUI {
    public GetCourseUI() {
    }
    final GetInputIn input_help = new GetInputIn();

    public String[] loaddata() {
        System.out.println("Please enter course code: \n");
        String code = input_help.getinput(System.in).nextLine();
        System.out.println("Please enter course description: \n");
        String info = input_help.getinput(System.in).nextLine();
        System.out.println("Please enter course start year: \n");
        String year = input_help.getinput(System.in).nextLine();
        return new String[]{code, info, year};
    }
}
