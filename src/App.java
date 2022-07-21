import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void config(){
        System.out.println(Constant.GREEN_BOLD+"STUDENTS INFO SYSTEM"+Constant.COLOR_RESET);
        List<Student> studentList = new LinkedList<>();
        int showMenuAgain = 1;
        int studentId = 0;
        Service service = new Service();
        try {
            while (showMenuAgain != 5) {
                service.mainMenu();
                Scanner input = new Scanner(System.in);
                showMenuAgain = input.nextInt();
                switch (showMenuAgain) {
                    case 1:
                        service.createStudent(studentList, input, studentId);
                        studentId++;
                        break;
                    case 2:
                        service.deleteStudent(studentList, input);
                        break;
                    case 3:
                        service.findStudent(studentList, input);
                        break;
                    case 4:
                        service.getStudents(studentList, input);
                        break;
                    case 5:
                        showMenuAgain = 5;
                        System.out.println(Constant.YELLOW + "Dastur to'xtatildi!" + Constant.COLOR_RESET);
                        break;
                    default:
                        System.out.println(Constant.YELLOW + "Menyuni tanlang!" + Constant.COLOR_RESET);
                }
            }
        } catch (Exception e) {
            System.out.println(Constant.RED + "ERROR: " + e.getMessage() + Constant.COLOR_RESET);
        }


    }
}
