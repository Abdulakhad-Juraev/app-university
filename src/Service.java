import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Service {

    // CREATE_STUDENTS
    public void createStudent(List<Student> studentList, Scanner input, int studentId) {
        System.out.println(
                "Talabani qo'shish uchun yo'nalishi tanlang!" +
                        "\n 1.Bakalavr" +
                        "\n 2.Magistr"
        );

        input = new Scanner(System.in);
        int yonalish = input.nextInt();
        if (yonalish == 1) System.out.println("Bakalavr uchun talaba qo'shish!");
        else if (yonalish == 2) System.out.println("Magistratura uchun o'quvchi qo'shish!");
        else {
            System.out.println(Constant.RED + "Yo'nalish tanlanmadi!" + Constant.COLOR_RESET);
            return;
        }

        String firstName = method("Talabaning ismini kiriting: ", input, "firstName");
        String lastName = method("Talabaning familiyasini kiriting: ", input, "lastName");
        String nation = method("Talabaning millatini kiriting: ", input, "nation");
        int gender = Integer.parseInt(method("Talabaning genderini tanlang: (raqamni tanlang)\n1. MALE \n2. FEMALE ", input, "gender"));
        String faculty = method("Talabaning fakultetini kiriting: ", input, "faculty");
        int admission = Integer.parseInt(method("Talabaning qabul yilini kiriting: ", input, "admission"));

        String gender1 = gender == 1 ? Constant.MALE : gender == 2 ? Constant.FEMALE : "no-selected";
        if (yonalish == 1) {
            String residential = method("Talabaning manzilini kiriting: ", input, "residential");
            studentList.add(new Student(
                    studentId + 1,
                    firstName,
                    lastName,
                    nation,
                    gender1,
                    faculty,
                    admission,
                    residential,
                    false
            ));
            studentId++;
            System.out.println(Constant.GREEN + "Bakalavr uchun talaba qo'shildi!" + Constant.COLOR_RESET);
        } else if (yonalish == 2) {
            String supervisor = method("Talabaning rahbarini kiriting: ", input, "supervisor");
            String topic = method("Talabaning ilmiy ishini kiriting: ", input, "topic");
            studentList.add(new Student(
                    studentId + 1,
                    firstName,
                    lastName,
                    nation,
                    gender1,
                    faculty,
                    admission,
                    supervisor,
                    topic,
                    true
            ));
            studentId++;
            System.out.println(Constant.GREEN + "Magistr uchun talaba qo'shildi!" + Constant.COLOR_RESET);
        }
    }

    // LIST_STUDENTS
    public void getStudents(List<Student> studentList, Scanner input) {
        System.out.println("\nTalabalar ro'yhati\n");
        if (!studentList.isEmpty())
            for (Student student : studentList)
                getAllStudents(student);
        else
            System.out.println(Constant.RED + "Talabalar mavjud emas! \n" + Constant.COLOR_RESET);
    }

    // FIND_STUDENT
    public void findStudent(List<Student> studentList, Scanner input) {
        System.out.println("Talabaning qidirish: ");
        if (!studentList.isEmpty()) {
            boolean found = false;
            int findStudent = Integer.parseInt(method("Talabaning id raqamini kiriting: ", input, "findStudent"));
            for (Student student : studentList) {
                if (student.getId() == findStudent) {
                    getAllStudents(student);
                    found = true;
                } else {
                    found = false;
                }
            }
            if (!found) {
                System.out.println(Constant.RED + "Siz kiritgan ID dagi talaba mavjud emas! \n" + Constant.COLOR_RESET);
            }
        } else
            System.out.println(Constant.RED + "Talabalar mavjud emas! \n" + Constant.COLOR_RESET);
    }

    // DELETE_STUDENT
    public void deleteStudent(List<Student> studentList, Scanner input) {
        System.out.println("Talabaning o'chirish: ");
        if (!studentList.isEmpty()) {
            boolean found = false;
            int findStudent = Integer.parseInt(method("Talabaning id raqamini kiriting: ", input, "findStudent"));
            ListIterator<Student> iterator = studentList.listIterator();
            while (iterator.hasNext()) {
                Student next = iterator.next();
                if (next.id == findStudent) {
                    iterator.remove();
                    System.out.println(Constant.GREEN + "Talaba o'chirildi! \n" + Constant.COLOR_RESET);
                    found = true;
                } else {
                    found = false;
                }
            }
            if (!found) {
                System.out.println(Constant.RED + "Siz kiritgan ID dagi talaba mavjud emas! \n" + Constant.COLOR_RESET);
            }
        } else
            System.out.println(Constant.RED + "Talabalar mavjud emas! \n" + Constant.COLOR_RESET);
    }

    // MyMethods
    public static String method(String text, Scanner input, String var) {
        System.out.println(text);
        input = new Scanner(System.in);
        return var = input.nextLine();
    }

    public static void getAllStudents(Student student) {
        System.out.println(student.magister ? "Magister talaba" : "Bakalavr talaba");
        System.out.println(
                "Student ID: " + student.id +
                        "\nFull Name: " + student.firstName + " " + student.lastName +
                        "\nNationality: " + student.nation +
                        "\nGender: " + student.gender +
                        "\nFaculty: " + student.faculty +
                        "\nAdmission Year: " + student.admission
        );
        System.out.println(student.magister ?
                "Supervisor Name: " + student.supervisor +
                        "\nResearch Topic: " + student.topic + "\n"
                :
                "Residential: " + student.residential + "\n");
    }

    public void mainMenu() {
        System.out.println("Menyu:" +
                "\n1. Talaba qo'shish" +
                "\n2. Talaba o'chirish" +
                "\n3. Talabani qidirish" +
                "\n4. Barcha talabalar" +
                "\n5. Chiqish \n"
        );
        System.out.print("Menyuni tanlang (raqamini): ");
    }
}
